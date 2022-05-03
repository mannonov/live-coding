package uz.tonkasoft.livecoding.application

import android.app.Application
import com.onesignal.OneSignal
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import uz.tonkasoft.livecoding.R
import uz.tonkasoft.livecoding.di.appModule

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule))
        }

        OneSignal.initWithContext(this);
        OneSignal.setAppId(this.getString(R.string.ONE_SIGNAL_ID));

    }

}