package vero.practicaandroidavanzado2.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import vero.practicaandroidavanzado2.data.local.SuperheroDatabase
import vero.practicaandroidavanzado2.data.local.SuperheroDAO


@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun providesSuperheroDatabase(@ApplicationContext context: Context): SuperheroDatabase {
        val db = Room.databaseBuilder(
            context,
            SuperheroDatabase::class.java, "superhero-db"
        ).build()
        return db
    }

    @Provides
    fun providesDao(db: SuperheroDatabase): SuperheroDAO {
        val dao = db.superheroDao()
        return dao
    }

}
