package com.example.android_project.presentation.auth.view

import android.content.Context.LOCATION_SERVICE
import android.content.Intent
import android.content.IntentFilter
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationManager.NETWORK_PROVIDER
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.android_project.databinding.FragmentFavouriteBinding
import com.example.android_project.presentation.receiver.AirplaneModeChangeReceiver
import com.example.android_project.presentation.receiver.MyBroadcastReceiver


class FavouriteFragment : Fragment() {

    private var _binding: FragmentFavouriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root

        var locationManager: LocationManager? = null
        locationManager = requireActivity().getSystemService(LOCATION_SERVICE) as LocationManager?

        try {
            locationManager?.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER, 0L, 0f, locationListener
            )
        } catch (ex: SecurityException) {
            Log.d("Mytag", "Secutiry Exception")
        }
    }
     private   val locationListener: LocationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                Toast.makeText(requireContext(), "${location.longitude.toString()} ${location.latitude.toString()}",
                    Toast.LENGTH_SHORT).show()

            }

         override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

         }
        }
    }


