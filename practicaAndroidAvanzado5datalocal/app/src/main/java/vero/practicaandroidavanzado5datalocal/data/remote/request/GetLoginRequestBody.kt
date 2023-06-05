package vero.practicaandroidavanzado5datalocal.data.remote.request

import com.squareup.moshi.Json

data class GetLoginRequestBody(
    @Json(name = "name") val email: String,
    @Json(name = "password") val password: String
)
