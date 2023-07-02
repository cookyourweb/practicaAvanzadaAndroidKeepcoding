package vero.practicaandroidavanzadoreentrega.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import vero.practicaandroidavanzadoreentrega.data.local.model.SuperHeroDetailLocal
import vero.practicaandroidavanzadoreentrega.data.local.model.SuperHeroLocal

@Dao
interface SuperHeroDAO {
    @Query("SELECT * FROM superheros")
    fun getAllSuperheros(): List<SuperHeroLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(superHero: List<SuperHeroLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSuperhero(superHero: SuperHeroLocal)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSuperheroDetail(superHeroDetailLocal: SuperHeroDetailLocal)

    @Delete
    fun deleteSuperHeroDetail(superHeroDetailLocal: SuperHeroDetailLocal)
}
