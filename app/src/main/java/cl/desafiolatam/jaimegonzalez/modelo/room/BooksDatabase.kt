package cl.desafiolatam.jaimegonzalez.modelo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [BooksPojo::class, DetailsBook::class], version = 1)

public abstract class BooksDatabase : RoomDatabase() {

    abstract fun dao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: BooksDatabase? = null
        fun getDatabase(context: Context): BooksDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BooksDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }


}

