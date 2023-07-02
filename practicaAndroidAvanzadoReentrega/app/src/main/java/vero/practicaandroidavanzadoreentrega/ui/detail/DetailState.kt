package vero.practicaandroidavanzadoreentrega.ui.detail

import com.google.android.gms.maps.model.LatLng
import vero.practicaandroidavanzadoreentrega.domain.SuperHeroDetail

sealed class DetailState {
    data class Success(val hero: SuperHeroDetail, val heroLocations: List<LatLng>) : DetailState()
    data class Failure(val error: String?) : DetailState()
    data class NetworkFailure(val code: Int) : DetailState()
}
