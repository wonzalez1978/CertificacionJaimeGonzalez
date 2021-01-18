package cl.desafiolatam.jaimegonzalez.modelo.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.desafiolatam.jaimegonzalez.modelo.room.DetailsBook

@Dao
interface Dao {

    @Query("SELECT * FROM books_table")
    fun getAllBooks(): LiveData<List<BooksPojo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: List<BooksPojo>)

    @Query("SELECT * FROM table_info Where id =:id")
    fun getDetails(id: Int): LiveData<DetailsBook>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook2(bookDetails: DetailsBook)


}