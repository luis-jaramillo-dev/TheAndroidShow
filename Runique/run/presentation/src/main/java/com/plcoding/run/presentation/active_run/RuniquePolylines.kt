package com.plcoding.run.presentation.active_run

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.google.android.gms.maps.model.JointType
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Polyline
import com.plcoding.core.domain.location.LocationTimestamp
import com.plcoding.run.presentation.active_run.components.maps.PolylineColorCalculator
import com.plcoding.run.presentation.active_run.components.maps.PolylineUI


@Composable
fun RuniquePolyLines(locations: List<List<LocationTimestamp>>) {
    val polylines = remember(locations) {

        locations.map {
            it.zipWithNext { timeStamp1, timestamp2 ->
                PolylineUI(
                    location1 = timeStamp1.location.location,
                    location2 = timestamp2.location.location,
                    color = PolylineColorCalculator.locationsToColor(
                        location1 = timeStamp1,
                        location2 = timestamp2
                    )
                )

            }
        }
    }

    polylines.forEach { polyline ->

        polyline.forEach { polylineUI ->
            Polyline(
                points = listOf(
                    LatLng( polylineUI.location1.lat, polylineUI.location1.long),
                    LatLng( polylineUI.location2.lat, polylineUI.location2.long)
                ),
                color = polylineUI.color,
                jointType = JointType.BEVEL
            )
        }
    }


}