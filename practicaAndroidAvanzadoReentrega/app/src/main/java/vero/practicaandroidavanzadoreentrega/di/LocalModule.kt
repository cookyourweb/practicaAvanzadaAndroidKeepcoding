package vero.practicaandroidavanzadoreentrega.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import vero.practicaandroidavanzadoreentrega.data.local.SuperHeroDAO
import vero.practicaandroidavanzadoreentrega.data.local.SuperHeroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
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

    private const val SHARED_PREFERENCES_FILE = "practicaandroidavanzadoreentrega"
}
