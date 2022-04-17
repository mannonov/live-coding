package uz.tonkasoft.livecoding.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.tonkasoft.livecoding.model.Book

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBooks(books: List<Book>)

    @Query("SELECT * FROM books_table")
    fun getAllBooksFromDatabase(): List<Book>

}