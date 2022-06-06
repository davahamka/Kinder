package com.davahamka.kinder.static

import androidx.compose.runtime.Composable
import com.google.android.gms.maps.model.LatLng

data class Nearest(
    val title: String,
    val name: String,
    val xp: Int,
    val condition: String,
    val imgUrl: String,
    val rating: Double,
    val location: Double,
    val position: LatLng
)

object NearestDataStatic {
    val dataCard = listOf<Nearest>(
        Nearest("Good Quality Banana", "Bu Siti", 100, "Good", "https://cdn.antaranews.com/cache/800x533/2017/05/20170508pisang.jpg", 4.0, 5.0, position = LatLng(-7.5692197,110.830672)),
        Nearest("Donate Rice Rendang", "Bu Sasi", 100, "Good", "https://assets.pikiran-rakyat.com/crop/74x12:890x646/x/photo/2021/03/28/2173660325.jpg", 4.0, 5.0, position = LatLng(-7.9472502,112.6033153)),
        Nearest("Mustard Greens Sale", "Pak Wisnu Kuncoro", 100, "Worth", "https://images.tokopedia.net/img/cache/500-square/VqbcmM/2020/5/29/ff339c1c-7516-4e46-8f9c-9edd1d81f495.png", 4.0, 5.0, position = LatLng(-7.9456493,112.6105829)),
        Nearest("Fresh Dragon Fruit", "Billy Haffas", 100, "Good", "https://res.cloudinary.com/dk0z4ums3/image/upload/v1616414949/attached_image/temukan-manfaat-buah-naga-yang-sarat-nutrisi.jpg", 4.0, 5.0, position = LatLng(-7.9456493,112.6105829)),
    )
}