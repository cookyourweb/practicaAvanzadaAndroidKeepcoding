package vero.practicaandroidavanzadoreentrega.data.remote.request

import com.squareup.moshi.Json

data class LocationsRequest(
    @Json(name = "id") val id: String
)
