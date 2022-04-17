package uz.tonkasoft.livecoding.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import uz.tonkasoft.livecoding.di.appModule

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@MyApp)
            modules(listOf(appModule))
        }

    }

}