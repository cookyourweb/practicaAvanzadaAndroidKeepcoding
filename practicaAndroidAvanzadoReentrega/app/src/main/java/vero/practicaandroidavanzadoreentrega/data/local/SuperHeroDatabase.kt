package vero.practicaandroidavanzadoreentrega.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import vero.practicaandroidavanzadoreentrega.data.local.model.SuperHeroDetailLocal
import vero.practicaandroidavanzadoreentrega.data.local.model.SuperHeroLocal

@Database(entities = [SuperHeroLocal::class, SuperHeroDetailLocal::class], version = 1)
abstract class SuperHeroDatabase : RoomDatabase() {
    abstract fun getDAO(): SuperHeroDAO
}
