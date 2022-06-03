package com.davahamka.kinder.presentation.donate

import android.Manifest
import android.annotation.SuppressLint
import android.location.Location
import android.location.LocationManager
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Eject
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.davahamka.kinder.R
import com.davahamka.kinder.dummy.DonateDummy
import com.davahamka.kinder.presentation.Permission
import com.davahamka.kinder.presentation.donate.components.ModalMethodSelection
import com.davahamka.kinder.presentation.home.components.ModalBottomShare
import com.davahamka.kinder.presentation.home.components.ModalDetailReceiver
import com.davahamka.kinder.static.NearestDataStatic
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import kotlinx.coroutines.launch
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource

private var currentLocation: Location? = null

@SuppressLint("MissingPermission")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DonateMapScreen(navController: NavHostController) {
    val context = LocalContext.current

    val modalBottomSheetState = rememberModalBottomSheetState(
            ModalBottomSheetValue.Hidden
        )

        val coroutineScope = rememberCoroutineScope()

        var cameraPositionState = rememberCameraPositionState {

            var singapore =  LatLng(-7.9354264,112.6239592)
            val fusedLocationClient = FusedLocationProviderClient(context)

            val cts = CancellationTokenSource()

            val getlongLat = fusedLocationClient.getCurrentLocation(LocationRequest.PRIORITY_HIGH_ACCURACY, cts.token)

            getlongLat.addOnSuccessListener {
                singapore = LatLng(it.latitude, it.longitude)
                position = CameraPosition.fromLatLngZoom(singapore, 16f)
            }


        }

        Permission(
            permission = Manifest.permission.ACCESS_FINE_LOCATION,
            rationale = "Access GPS",
            permissionNotAvailableContent = {
                Column() {
                    Text(text = "Oh no!")
                }
            }
        ) {

            ModalBottomSheetLayout(
                sheetState = modalBottomSheetState,
                sheetContent = {
                    ModalDetailReceiver(navController)
                }) {
                GoogleMap(
                    modifier = Modifier.fillMaxSize(),
                    cameraPositionState = cameraPositionState,
                    properties = MapProperties(isMyLocationEnabled = true),
                    uiSettings = MapUiSettings(myLocationButtonEnabled = true),
                    onMapLoaded = {

                    }
                ) {

                    NearestDataStatic.dataCard.forEach {
                        val iconMarker = BitmapDescriptorFactory.fromResource(R.drawable.ic_food_loc)
                        Marker(
                            position = it.position,
                            title = it.name,
                            icon = iconMarker,
                            snippet = "Tes",
                            onClick = {
                                coroutineScope.launch { modalBottomSheetState.show() }
                                true
                            }
                        )
                    }

                }
            }
        }

}