package uz.tonkasoft.livecoding.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uz.tonkasoft.livecoding.database.AppDatabase
import uz.tonkasoft.livecoding.networking.ApiClient
import uz.tonkasoft.livecoding.networking.ApiService
import uz.tonkasoft.livecoding.repository.MainRepository
import uz.tonkasoft.livecoding.util.NetworkHelper
import uz.tonkasoft.livecoding.viewmodel.MainViewModel

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(repository = get())
    }

    single<MainRepository> {
        MainRepository(remoteDataSource = get(), localDataSource = get(), networkHelper = get())
    }

    single<AppDatabase> {
        AppDatabase.getInstance(context = get())
    }

    single<ApiService> {
        ApiClient.createApiService()
    }

    single<NetworkHelper> {
        NetworkHelper(context = get())
    }

}