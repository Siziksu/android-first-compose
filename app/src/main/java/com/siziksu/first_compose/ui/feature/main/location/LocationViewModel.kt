package com.siziksu.first_compose.ui.feature.main.location

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.location.FusedLocationProviderClient
import com.siziksu.first_compose.common.onError
import com.siziksu.first_compose.ui.feature.main.location.model.LocationThrowable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LocationViewModel(
    private val fusedLocationProviderClient: FusedLocationProviderClient
) : ViewModel() {

    private val _location = MutableStateFlow("")
    val location: StateFlow<String> = _location

    fun init(context: Context) {
        GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context).let { resultCode ->
            if (resultCode == ConnectionResult.SUCCESS) {
                checkPermissions(context, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION))
            } else {
                _location.value = ""
                onError(LocationThrowable(), TAG, METHOD_INIT)
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        fusedLocationProviderClient.lastLocation.addOnSuccessListener { location ->
            _location.value = "Location: ${location.latitude},${location.longitude}\nalt=${location.altitude}\nacc=${location.accuracy}"
        }
    }

    private fun checkPermissions(context: Context, permissionsToRequest: Array<String>) {
        val remainPermissions = permissionsToRequest.filter {
            ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_DENIED
        }.toTypedArray()
        when {
            remainPermissions.isEmpty() -> getLocation()
            remainPermissions.any { true } -> Unit
            else -> Unit
        }
    }

    companion object {

        private const val TAG = "LocationViewModel"
        private const val METHOD_INIT = "LocationViewModel.init()"
    }
}
