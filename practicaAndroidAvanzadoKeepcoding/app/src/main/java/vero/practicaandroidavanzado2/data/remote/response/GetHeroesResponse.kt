package vero.practicaandroidavanzado2.data.remote.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json



//NIVEL PRESENTACION
//con Moshi json

//MODO ESPAGUETI
@Entity
data class GetHeroesResponseOld(

    @PrimaryKey @ColumnInfo (name="id") @Json(name ="id") val  id: String,
    @ColumnInfo  @Json(name ="name") val name: String,
    @ColumnInfo @Json (name ="description")val description: String,
    @ColumnInfo @Json (name ="photo") val photo: String,
    @ColumnInfo @Json (name ="favorite") val favorite: Boolean?,

)
//favorite no viene de la api y es opcional.
//EL view model recoge los datos que recoge del repositorio y utiiliza lo que necesita

//NETWORK
data class GetHeroesResponse(
@PrimaryKey  @Json(name ="id") val  id: String,
@Json(name ="name") val name: String,
 @Json (name ="description")val description: String,
 @Json (name ="photo") val photo: String,
 @Json (name ="favorite") val favorite: Boolean?,

)



//UI
data class Superhero(
     val  id: String,
     val name: String,
)
