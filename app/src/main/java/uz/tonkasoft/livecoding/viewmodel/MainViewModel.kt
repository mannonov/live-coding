package uz.tonkasoft.livecoding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*
import uz.tonkasoft.livecoding.model.Book
import uz.tonkasoft.livecoding.repository.MainRepository
import uz.tonkasoft.livecoding.util.Resource


class MainViewModel(private val repository: MainRepository) : ViewModel() {

    private val _booksLiveData = MutableLiveData<Resource<List<Book>>>()
    val booksLiveData: LiveData<Resource<List<Book>>> get() = _booksLiveData

    fun getBooks() {

        _booksLiveData.value = Resource.loading(null)

        GlobalScope.launch(Dispatchers.IO) {

            _booksLiveData.postValue(repository.getBooks())

        }

    }
}