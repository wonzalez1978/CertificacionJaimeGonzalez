package cl.desafiolatam.jaimegonzalez.modelo.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_info")
data class DetailsBook(
    @PrimaryKey val id: Int,
    val author: String,
    val imageLink: String,
    val language: String,
    val pages: Int,
    val title: String,
    val year: Int,
    val price: Int,
    val delivery: Boolean
)
