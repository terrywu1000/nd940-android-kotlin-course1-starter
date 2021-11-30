package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable


class ShoeViewModel : ViewModel() {

//    private lateinit var shoeList: mutableList<Shoe>


    private var shoeList = mutableListOf(
        Shoe(
            name = "Cloud BOUNSE+ Sport Shoes",
            size = 9.5,
            company = "LI-NING",
            description = "no description",
            images = mutableListOf("pic1")
        ),
        Shoe(
            name = "Wearable Anti-Slippery Lining Sport Shoes",
            size = 10.0,
            company = "LI-NING",
            description = "no description",
            images = mutableListOf("pic2")
        ),
        Shoe(
            name = "Boom Cloud Cushion Reflective Lining Support Durable Sport Shoes",
            size = 8.5,
            company = "LI-NING",
            description = "no description",
            images = mutableListOf("pic3")
        ),
        Shoe(
            name = "Lining Breathable Cushioning Professional Sports Shoes",
            size = 9.5,
            company = "LI-NING",
            description = "no description",
            images = mutableListOf("pic4")
        ),
        Shoe(
            name = "Lining Cloud BOUNSE+ Sport Shoes",
            size = 9.0,
            company = "LI-NING",
            description = "no description",
            images = mutableListOf("pic5")
        ),
        Shoe(
            name = "Lining Breathable Cushioning Professional Sports Shoes",
            size = 10.0,
            company = "LI-NING",
            description = "no description",
            images = mutableListOf("pic6")
        )
    )

}