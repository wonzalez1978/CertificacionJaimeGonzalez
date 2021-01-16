package cl.desafiolatam.jaimegonzalez.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Dao
import cl.desafiolatam.jaimegonzalez.modelo.BooksPojo
import cl.desafiolatam.jaimegonzalez.modelo.RetrofitClient
import cl.desafiolatam.jaimegonzalez.modelo.room.BooksDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(context: Context) {


val bookDao : cl.desafiolatam.jaimegonzalez.modelo.room.Dao = BooksDatabase.getDatabase(context).dao()

val getAll :LiveData<List<BooksPojo>> = bookDao.getAllBooks()

    fun loadApiData(){
        val call = RetrofitClient.retrofitInstance().getBooks()
        call.enqueue(object : Callback<List<BooksPojo>> {
            override fun onResponse(
                call: Call<List<BooksPojo>>,
                response: Response<List<BooksPojo>>
            ) {
                Log.d("Main", "${response.body()}")
                Log.d("Main", "${response.isSuccessful()}")
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
}