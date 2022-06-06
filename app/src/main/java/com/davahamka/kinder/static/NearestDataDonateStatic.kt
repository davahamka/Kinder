package com.davahamka.kinder.static

import androidx.compose.runtime.Composable
import com.google.android.gms.maps.model.LatLng

data class NearestDonate(
    val title: String,
    val name: String,
    val xp: Int,
    val condition: String,
    val imgUrl: String,
    val rating: Double,
    val location: Double,
    val position: LatLng
)

object NearestDataDonateStatic {
    val dataCard = listOf<NearestDonate>(
        NearestDonate("Rice With Satay", "Hadi", 100, "Good", "https://awsimages.detik.net.id/community/media/visual/2021/03/06/sate-pak-heri-asli-2.jpeg?w=700&q=90", 4.0, 5.0, position = LatLng(-7.5682219,110.8293164)),
        NearestDonate("Medium Quality Beef", "Raymon", 100, "Good", "https://www.jessicagavin.com/wp-content/uploads/2020/06/cuts-of-beef-12.jpg", 4.0, 5.0, position = LatLng(-7.5682219,110.8293164)),
        NearestDonate("Egg", "Dafa", 100, "Good", "https://cdn.britannica.com/94/151894-050-F72A5317/Brown-eggs.jpg", 4.0, 5.0, position = LatLng(-7.5680953,110.8290245)),
        NearestDonate("Rice With Satay", "Pak Budi", 100, "Good", "https://awsimages.detik.net.id/community/media/visual/2021/03/06/sate-pak-heri-asli-2.jpeg?w=700&q=90", 4.0, 5.0, position = LatLng(-7.9354264,112.6239592)),
        NearestDonate("Cheap Sale Pineapple", "Pak Agus", 50, "Good", "https://asset.kompas.com/crops/yC1HTVBUaikv5UKiqJHdferO26s=/192x128:1728x1152/750x500/data/photo/2021/07/31/6104430e3b137.jpg", 4.0, 5.0, position = LatLng(-7.9488457,112.6034115)),
        NearestDonate("Donate Rice Rendang", "Bu Sasi", 100, "Good", "https://assets.pikiran-rakyat.com/crop/74x12:890x646/x/photo/2021/03/28/2173660325.jpg", 4.0, 5.0, position = LatLng(-7.9472502,112.6033153)),
        NearestDonate("Mustard Greens Sale", "Pak Wisnu Kuncoro", 100, "Worth", "https://images.tokopedia.net/img/cache/500-square/VqbcmM/2020/5/29/ff339c1c-7516-4e46-8f9c-9edd1d81f495.png", 4.0, 5.0, position = LatLng(-7.9456493,112.6105829)),
        NearestDonate("Fresh Dragon Fruit", "Billy Haffas", 100, "Good", "https://res.cloudinary.com/dk0z4ums3/image/upload/v1616414949/attached_image/temukan-manfaat-buah-naga-yang-sarat-nutrisi.jpg", 4.0, 5.0, position = LatLng(-7.9456493,112.6105829)),
    )
}