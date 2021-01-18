package cl.desafiolatam.jaimegonzalez.modelo.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books_table")
data class BooksPojo(
    @PrimaryKey val id: Int, val title: String, val author: String,
    val language: String, val imageLink: String,
)
