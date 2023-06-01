package vero.practicaandroidavanzado5datalocal.data.local

import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesManager @Inject constructor(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val TOKEN_KEY = "TOKEN"
    }

    fun getToken(): String {
        return sharedPreferences.getString(TOKEN_KEY, "").orEmpty()
    }

    fun setToken(token: String) {
        with(sharedPreferences.edit()) {
            putString(TOKEN_KEY, token)
            apply()
        }
    }
}
