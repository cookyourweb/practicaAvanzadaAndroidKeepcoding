package vero.practicaandroidavanzado5datalocal.data.remote.request
import com.squareup.moshi.Json

data class GetLocationRequestBody(
    @Json(name = "id") val id: String
)
