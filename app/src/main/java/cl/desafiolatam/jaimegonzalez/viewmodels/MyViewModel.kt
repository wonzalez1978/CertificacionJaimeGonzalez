package cl.desafiolatam.jaimegonzalez.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import cl.desafiolatam.jaimegonzalez.modelo.BooksPojo

class MyViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : Repository = Repository(application)

val getAllBooks : LiveData<List<BooksPojo>> = repository.getAll

    fun obtenerValor() {
        repository.loadApiData()
    }
}