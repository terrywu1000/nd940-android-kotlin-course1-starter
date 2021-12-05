package com.udacity.shoestore

import android.os.Bundle
import android.text.Layout
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.*
import android.widget.TextView
import androidx.appcompat.view.menu.ShowableListMenu
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.MarginLayoutParamsCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentListBinding
import com.udacity.shoestore.models.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

//    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list,container,false)
//        binding = DataBindingUtil.inflate(
//            inflater,
//            R.layout.fragment_list,
//            false
//        )

        binding.addButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_listFragment_to_newFragment)
        )

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        binding.shoeViewModel = viewModel

//        binding.setLifecycleOwner(this)

        while (viewModel.shoeListEmpty.value == false) {

            viewModel.nextShoeItem()

            val text_view: TextView = TextView(this.context)

//            var params: LinearLayoutCompat.LayoutParams = LinearLayoutCompat.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
//            params.setMargins(16,16,16,16)

            text_view.setTextSize(TypedValue.COMPLEX_UNIT_SP,18F)
            text_view.setPaddingRelative(16,16,16,16)

            text_view.text = viewModel.shoeItemString.value
            binding.listItemRoot.addView(text_view)

        }

        return binding.root
    }
}























