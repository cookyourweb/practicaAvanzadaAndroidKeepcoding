package vero.practicaandroidavanzado5datalocal.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SuperHero(
    val id: String,
    val name: String,
    val photo: String
) : Parcelable

//fun SuperHero.toLocal(): SuperHeroLocal {
//    return SuperHeroLocal(this.id, this.name, this.photo, "", false)
//}
