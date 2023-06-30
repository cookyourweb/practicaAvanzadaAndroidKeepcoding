package vero.practicaandroidavanzado2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import vero.practicaandroidavanzado2.data.local.model.LocalSuperhero

@Database(entities = [LocalSuperhero::class], version = 1)
abstract class SuperheroDatabase : RoomDatabase() {
    abstract fun superheroDao(): SuperheroDAO
}
