package cl.desafiolatam.jaimegonzalez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.desafiolatam.jaimegonzalez.vista.BookFragment

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.containerfragment, BookFragment()).commit()

    }

}