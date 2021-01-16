package cl.desafiolatam.jaimegonzalez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cl.desafiolatam.jaimegonzalez.modelo.BooksPojo
import cl.desafiolatam.jaimegonzalez.modelo.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadApiData()
    }
    fun loadApiData(){
        val call = RetrofitClient.retrofitInstance().getBooks()
        call.enqueue(object : Callback<List<BooksPojo>>{
            override fun onResponse(
                call: Call<List<BooksPojo>>,
                response: Response<List<BooksPojo>>
            ) {
                Log.d("Main", "${response.body()}")
                Log.d("Main", "${response.isSuccessful()}")
            }

            override fun onFailure(call: Call<List<BooksPojo>>, t: Throwable) {
                Log.d("Main", "$t")
            }

        })
    }
}