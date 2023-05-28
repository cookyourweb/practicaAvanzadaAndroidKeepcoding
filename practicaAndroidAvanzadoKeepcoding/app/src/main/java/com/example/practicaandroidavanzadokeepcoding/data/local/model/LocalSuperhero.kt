import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//LOCAL
//como voy a ver tema de cache para saber si estan o no la photo y la descp no las pongo en local
@Entity
data class LocalSuperHero(
//NIVEL PRESENTACION
    //con Moshi json
    @PrimaryKey @ColumnInfo(name="id") val id: String,
    @ColumnInfo val name: String,
    @ColumnInfo val favorite: Boolean?,

    )