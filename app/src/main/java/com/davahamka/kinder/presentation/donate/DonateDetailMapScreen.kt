package com.davahamka.kinder.presentation.donate

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.davahamka.kinder.R
import com.davahamka.kinder.presentation.home.components.ModalDetailItem
import com.davahamka.kinder.presentation.home.components.ModalDetailReceiver
import com.davahamka.kinder.static.NearestDataStatic
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DonateDetailMapScreen(navController: NavController, showDefault: String?) {
    val singapore =  LatLng(-7.5692197,110.830672)

    val modalBottomSheetState = rememberModalBottomSheetState(
        if(showDefault=="true") ModalBottomSheetValue.Hidden else ModalBottomSheetValue.HalfExpanded
    )


    val coroutineScope = rememberCoroutineScope()

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 16f)
    }

    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            ModalDetailItem(navController)
        }) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
//                properties = MapProperties(isMyLocationEnabled = true),
            uiSettings = MapUiSettings(myLocationButtonEnabled = true)
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