package vero.practicaandroidavanzado5datalocal.ui.superherodetail

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint
import vero.practicaandroidavanzado5datalocal.R
import vero.practicaandroidavanzado5datalocal.databinding.FragmentSuperHeroDetailBinding
import kotlin.math.log


@AndroidEntryPoint
class SuperHeroDetailFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentSuperHeroDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    private val args: SuperHeroDetailFragmentArgs by navArgs()
    private val viewModel: SuperHeroDetailViewModel by viewModels()


    private lateinit var googleMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSuperHeroDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            viewModel.state.observe(viewLifecycleOwner) {
                when (it) {
                    is DetailState.Success -> {
                        heroName.text = it.hero.name
                        heroImage.load(it.hero.photo)
                        heroName.text = it.hero.name
                        heroDescription.text = it.hero.description
                        heroFavorite.text =
                            if (it.hero.favourite) getString(R.string.fav) else getString(R.string.not_fav)

                        it.heroLocations.forEach { latLng ->
                            googleMap.addMarker(
                                MarkerOptions()
                                    .position(latLng)
                                    .title(it.hero.name)
                            )
                        }
                    }
                    else -> {}
                }
            }

            heroFavorite.setOnClickListener { viewModel.toggleFavorite() }
        }

        viewModel.getHeroDetail(args.superheroName, args.superhero.id)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val hasPermission = ActivityCompat.checkSelfPermission(
            requireContext(), Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(
            requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (!hasPermission) {
            val permissionLauncher =
                registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
                    if (isGranted) {
                        //getUserLocation()
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "No se puede mostrar la ubicación sin permisos", Toast.LENGTH_LONG
                        ).show()

                    }
                }
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        if (ActivityCompat.checkSelfPermission(
                requireContext(), Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            getUserLocation()
        }

        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(
            MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney")
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 1f))
    }

    @SuppressLint("MissingPermission")
    private fun getUserLocation() {
        val fusedLocationProviderClient: FusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireContext())
        fusedLocationProviderClient.lastLocation.addOnCompleteListener {
            val myLocation = LatLng(it.result.latitude, it.result.longitude)
            googleMap.addMarker(
                MarkerOptions()
                    .position(myLocation)
                    .title("My location")
            )
        }
    }
}

