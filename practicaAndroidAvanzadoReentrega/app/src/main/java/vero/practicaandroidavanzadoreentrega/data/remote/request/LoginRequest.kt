package vero.practicaandroidavanzadoreentrega.data.remote.request

import com.squareup.moshi.Json

data class LoginRequest(
    @Json(name = "name") val email: String,
    @Json(name = "password") val password: String
)
