package cl.desafiolatam.jaimegonzalez.modelo

import cl.desafiolatam.jaimegonzalez.modelo.room.BooksPojo
import cl.desafiolatam.jaimegonzalez.modelo.room.DetailsBook
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksApi {
    @GET("books")
    fun getBooks(): Call<List<BooksPojo>>

    @GET("bookDetail/{id}")
    fun getDetails(@Path("id") id: Int): Call<DetailsBook>
}