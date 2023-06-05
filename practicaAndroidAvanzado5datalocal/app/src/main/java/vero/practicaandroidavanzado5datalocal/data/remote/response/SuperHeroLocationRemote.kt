package vero.practicaandroidavanzado5datalocal.data.remote.response

import com.squareup.moshi.Json

data class SuperHeroLocationRemote(
    @Json(name = "hero") val hero: SuperHeroLocationIdRemote,
    @Json(name = "dateShow") val dateShow: String,
    @Json(name = "id") val id: String,
    @Json(name = "latitud") val latitud: String,
    @Json(name = "longitud") val longitud: String,
) {
    data class SuperHeroLocationIdRemote(
        @Json(name = "id") val id: String
    )
}
