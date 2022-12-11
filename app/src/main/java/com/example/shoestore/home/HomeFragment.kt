package com.example.shoestore.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentHomeBinding
import com.example.shoestore.home.business.ShoeAdapter
import com.example.shoestore.home.model.Shoe

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: ShoeViewModel

    val args: HomeFragmentArgs by navArgs()

    private var shoeList : ArrayList<Shoe> = ArrayList()
    private lateinit var adapter : ShoeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        setupMenu()

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        viewModel.getShoes()

        checkAddShoe()

        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            shoeList = it as ArrayList<Shoe>
            setupRecyclerView()
        })

        binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_formFragment)
        }


        return binding.root
    }

    private fun setupRecyclerView() {
        adapter = ShoeAdapter(shoeList)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
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
}