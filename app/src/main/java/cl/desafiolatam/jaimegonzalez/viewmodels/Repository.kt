package cl.desafiolatam.jaimegonzalez.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import cl.desafiolatam.jaimegonzalez.modelo.room.BooksPojo
import cl.desafiolatam.jaimegonzalez.modelo.room.DetailsBook
import cl.desafiolatam.jaimegonzalez.modelo.RetrofitClient
import cl.desafiolatam.jaimegonzalez.modelo.room.BooksDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(context: Context) {


    var bookDao: cl.desafiolatam.jaimegonzalez.modelo.room.BookDao =
        BooksDatabase.getDatabase(context).dao()

    val getAll: LiveData<List<BooksPojo>> = bookDao.getAllBooks()

    fun getInformation(id: Int): LiveData<DetailsBook> {
        return bookDao.getDetails(id)
    }

    fun loadApiData() {
        val call = RetrofitClient.retrofitInstance().getBooks()
        call.enqueue(object : Callback<List<BooksPojo>> {
            override fun onResponse(
                call: Call<List<BooksPojo>>,
                response: Response<List<BooksPojo>>
            ) {
                Log.d("Main", "${response.body()}")

                CoroutineScope(Dispatchers.IO).launch {
                    response.body()?.let {
                        bookDao.insertBook(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<BooksPojo>>, t: Throwable) {
                Log.d("Main", "$t")
            }

        })
    }

    fun loadApiDetails(id: Int) {
        val service = RetrofitClient.retrofitInstance()
        val call = service.getDetails(id)
        call.enqueue(object : Callback<DetailsBook> {
            override fun onResponse(call: Call<DetailsBook>, response: Response<DetailsBook>) {
                Log.d("repositoryDetails", "${response.body()}")
                Log.d("repositoryDetail", "${response.isSuccessful}")
                CoroutineScope(Dispatchers.IO).launch {
                    response.body()?.let {
                        bookDao.insertBook2(it)
                    }
                }
            }

            override fun onFailure(call: Call<DetailsBook>, t: Throwable) {
                Log.d("repository", "$t")
            }

        })


    }

}