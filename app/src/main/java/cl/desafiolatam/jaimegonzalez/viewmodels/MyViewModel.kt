package cl.desafiolatam.jaimegonzalez.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cl.desafiolatam.jaimegonzalez.modelo.room.BooksPojo
import cl.desafiolatam.jaimegonzalez.modelo.room.DetailsBook

class MyViewModel(application: Application) : AndroidViewModel(application) {

    private val selected = MutableLiveData<BooksPojo>()


    fun select(books: BooksPojo) {
        selected.value = books
    }
    private val repository: Repository = Repository(application)

    val getAllBooks: LiveData<List<BooksPojo>> = repository.getAll

    fun obtenerValor() {
        repository.loadApiData()
    }

     fun getBookInformation(): LiveData<DetailsBook> {
        val id = selected.value!!.id
        repository.loadApiDetails(id)
        return repository.getInformation(id)
    }
}