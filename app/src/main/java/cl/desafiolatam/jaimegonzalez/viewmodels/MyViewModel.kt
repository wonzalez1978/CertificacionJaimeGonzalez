package cl.desafiolatam.jaimegonzalez.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cl.desafiolatam.jaimegonzalez.modelo.BooksPojo
import cl.desafiolatam.jaimegonzalez.modelo.DetailsBook

class MyViewModel(application: Application) : AndroidViewModel(application) {
    private val selected = MutableLiveData<BooksPojo>()
    private val repository: Repository = Repository(application)

    val getAllBooks: LiveData<List<BooksPojo>> = repository.getAll

    fun select(books: BooksPojo) {
        selected.value = books
    }

    fun obtenerValor() {
        repository.loadApiData()
    }

     fun getBookInformation(): LiveData<DetailsBook> {
        val id = selected.value!!.id
        repository.loadApiData()
        return repository.getBookDetails(id)
    }
}