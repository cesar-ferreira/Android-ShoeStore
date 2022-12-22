package com.example.shoestore.home

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentHomeBinding
import com.example.shoestore.databinding.ShoeItemBinding
import com.example.shoestore.home.model.Shoe

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: ShoeViewModel

    val args: HomeFragmentArgs by navArgs()

    private var shoeList : ArrayList<Shoe> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.controller = this

        setupMenu()

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        viewModel.getShoes()

        checkAddShoe()

        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            shoeList = it as ArrayList<Shoe>
            setupListView(binding.shoes, shoeList)
        })


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

    private fun setupMenu() {
        setHasOptionsMenu(true)
    }

    private fun checkAddShoe() {
        args.newShoe.let {
            viewModel.addShoe(it)
        }
    }

    private fun setupListView(list: LinearLayout, items: ArrayList<Shoe>) {
        list.removeAllViews()
        items.forEach { shoe ->
            binding = FragmentHomeBinding.inflate(layoutInflater)
            val shoeBinding = ShoeItemBinding.inflate(layoutInflater)
            shoeBinding.shoeTitle.text = shoe.name
            shoeBinding.shoeDescription.text = shoe.description
            list.addView(shoeBinding.root)
        }
    }

    fun navigateToForm() {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFormFragment())
    }
}