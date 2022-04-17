package uz.tonkasoft.livecoding.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books_table")
data class Book(
    val title: String,
    val image: String,
    @PrimaryKey
    val id: String,
)