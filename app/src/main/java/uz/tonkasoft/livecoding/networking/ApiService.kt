package uz.tonkasoft.livecoding.networking

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import uz.tonkasoft.livecoding.model.Book

interface ApiService {

    @GET(value = "books")
    fun getBooksAsync(): Deferred<Response<List<Book>>>

}