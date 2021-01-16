package cl.desafiolatam.jaimegonzalez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cl.desafiolatam.jaimegonzalez.modelo.BooksPojo
import cl.desafiolatam.jaimegonzalez.modelo.RetrofitClient
import cl.desafiolatam.jaimegonzalez.vista.BookFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.containerfragment, BookFragment()).commit()

    }

}