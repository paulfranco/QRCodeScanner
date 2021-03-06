package co.paulfran.qrcodescanner.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.room.Room
import co.paulfran.qrcodescanner.data.db.QrDao
import co.paulfran.qrcodescanner.data.db.QrDatabase
import co.paulfran.qrcodescanner.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    @Singleton
    fun providePreferences(context: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): QrDatabase {
        return Room.databaseBuilder(app, QrDatabase::class.java, Constants.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(db: QrDatabase): QrDao {
        return db.qrDao()
    }
}