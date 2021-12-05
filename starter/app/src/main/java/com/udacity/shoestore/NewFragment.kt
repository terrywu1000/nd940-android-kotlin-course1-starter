package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.ShowableListMenu
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentNewBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_new.*

class NewFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

    private lateinit var newImage: MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentNewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_new, container, false)
//        binding = DataBindingUtil.inflate(
//            inflater,
//            R.layout.fragment_list,
//            false
//        )

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)


        binding.shoeViewModel = viewModel

        binding.setLifecycleOwner(this)

        binding.cancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_newFragment_to_listFragment)
        )

        binding.saveButton.setOnClickListener {

            newShoe.name = binding.nameContent.text.toString()
            newShoe.size = binding.sizeContent.text.toString().toDouble()
            newShoe.company = binding.companyContent.text.toString()
            newShoe.description = binding.descriptionContent.text.toString()
//            newShoe.images = newImage.add(binding.imagesContent.text.toString())

            viewModel.addShoeItem(newShoe)

//            Navigation.createNavigateOnClickListener(R.id.action_newFragment_to_listFragment)
            findNavController().navigate(NewFragmentDirections.actionNewFragmentToListFragment())

        }

        return binding.root
    }
}

