package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

var newShoe = Shoe(name = "", size = 0.0, company = "", description = "", images = listOf(""))

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
