package vero.practicaandroidavanzado5datalocal.modulesDepInj

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import vero.practicaandroidavanzado5datalocal.data.local.SuperHeroDAO
import vero.practicaandroidavanzado5datalocal.data.local.SuperHeroDatabase

@Module
//donnde va a tener que convivir
@InstallIn(SingletonComponent::class)

//declaramos object porque simplemente va a ser un gestor de dependencias
//  vva a ser un módulo de dagger, adaptate a sus configuraciones
object LocalModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): SuperHeroDatabase {
        return Room.databaseBuilder(
            context,
            SuperHeroDatabase::class.java, "database-name"
        ).build()
    }

    @Provides
    fun provideDao(database: SuperHeroDatabase): SuperHeroDAO {
        return database.getDAO()
    }

    @Provides
    fun provideSharedPreferneces(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_FILE, Context.MODE_PRIVATE)
    }

    private const val SHARED_PREFERENCES_FILE = "AndroidAvanzado"
}
