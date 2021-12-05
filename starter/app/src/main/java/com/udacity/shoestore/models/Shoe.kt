package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.NewFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.newShoe
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    var images: List<String> = mutableListOf()
//    val images: List<String> = mutableListOf()
) : Parcelable

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

class ShoeViewModel : ViewModel() {

//    private lateinit var shoeList: mutableList<Shoe>

    private val _shoeItemString = MutableLiveData<String>()
    val shoeItemString: LiveData<String>
        get() = _shoeItemString

    private val _shoeListEmpty = MutableLiveData<Boolean>()
    val shoeListEmpty: LiveData<Boolean>
        get() = _shoeListEmpty

    private var index = 0

    init {
        _shoeListEmpty.value = false
//        nextShoeItem()
//        shoeList.add(newShoe)
    }

    fun nextShoeItem() {
//        if (shoeList.isNotEmpty()) {
        if (index < shoeList.size) {
            _shoeItemString.value =
                "NAME: " + (shoeList[index].name) + "\n" + "SIZE: " + (shoeList[index].size) + "\n" + "COMPANY: " + (shoeList[index].company) + "\n" + "DESCRIPTION: " + (shoeList[index].description) + "\n" + "IMAGES: " + (shoeList[index].images) + "\n"
//            shoeList.removeAt(0)
            index++
        } else {
            _shoeListEmpty.value = true
            _shoeItemString.value = ""
        }

    }

    fun addShoeItem(new: Shoe) {
        shoeList.add(new)
//        nextShoeItem()
    }


}