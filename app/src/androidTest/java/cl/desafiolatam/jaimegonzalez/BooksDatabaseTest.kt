package cl.desafiolatam.jaimegonzalez


import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import cl.desafiolatam.jaimegonzalez.modelo.room.BookDao
import cl.desafiolatam.jaimegonzalez.modelo.room.BooksDatabase
import cl.desafiolatam.jaimegonzalez.modelo.room.BooksPojo
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class BooksDatabaseTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    private lateinit var bookdao: BookDao
    private lateinit var database: BooksDatabase

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, BooksDatabase::class.java).build()
        bookdao = database.dao()

    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertBooks_empty() = runBlocking {
        //GIVEN
        val bookList = listOf<BooksPojo>()
        //WHEN
        bookdao.insertBook(bookList)
        //THEM
        bookdao.getAllBooks().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isEmpty()
        }
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertThat("cl.desafiolatam.jaimegonzalez").isEqualTo(appContext.packageName)
    }
}