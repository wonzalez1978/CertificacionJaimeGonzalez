package cl.desafiolatam.jaimegonzalez.modelo

import retrofit2.Call
import retrofit2.http.GET

interface BooksApi {
    @GET("books")
    fun getBooks(): Call<List<BooksPojo>>
}