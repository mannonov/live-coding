package uz.tonkasoft.livecoding.repository

import uz.tonkasoft.livecoding.database.AppDatabase
import uz.tonkasoft.livecoding.model.Book
import uz.tonkasoft.livecoding.networking.ApiService
import uz.tonkasoft.livecoding.util.NetworkHelper
import uz.tonkasoft.livecoding.util.Resource

class MainRepository(
    private val remoteDataSource: ApiService,
    private val localDataSource: AppDatabase,
    private val networkHelper: NetworkHelper,
) {

    suspend fun getBooks(): Resource<List<Book>>? {

        var result: Resource<List<Book>>?

        if (networkHelper.isNetWorkConnected()) {

            with(remoteDataSource.getBooksAsync().await()) {

                if (this.isSuccessful) {

                    result = Resource.success(this.body())
                    this.body()?.let { localDataSource.appDao().insertBooks(it) }

                } else {

                    result = Resource.error(this.errorBody()?.string() ?: "Empty Body", null)

                }

            }

        } else {

            result = Resource.success(localDataSource.appDao().getAllBooksFromDatabase())

        }

        return result

    }

}