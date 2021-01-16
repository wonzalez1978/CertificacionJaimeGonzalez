package cl.desafiolatam.jaimegonzalez.modelo.room

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.desafiolatam.jaimegonzalez.modelo.BooksPojo

@Database(entities = [BooksPojo::class], version = 1)

public abstract class BooksDatabase : RoomDatabase() {

    abstract fun dao(): Dao

    companion object{
        @Volatile
        var INSTANCE: BooksDatabase? = null
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

class JaimeGonzalez : Application() {
    companion object {
        lateinit var database: BooksDatabase
    }

    override fun onCreate() {
        super.onCreate()
        JaimeGonzalez.database =
            Room.databaseBuilder(this, BooksDatabase::class.java, "task_db").build()
    }
}