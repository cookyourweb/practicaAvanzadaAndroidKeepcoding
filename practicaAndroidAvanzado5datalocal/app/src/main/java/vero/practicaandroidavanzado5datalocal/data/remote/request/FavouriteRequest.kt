package vero.practicaandroidavanzado5datalocal.data.remote.request

import com.squareup.moshi.Json

data class FavouriteRequest(
    @Json(name = "hero") val hero: String
)
