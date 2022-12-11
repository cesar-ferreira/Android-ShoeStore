package com.example.shoestore.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.shoestore.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater)

        setupUI()

        return binding.root
    }

    private fun setupUI() {
        binding.apply {
            textViewName.text = args.shoe.name
            textViewSize.text = args.shoe.size.toString()
            textViewCompany.text = args.shoe.company
            textViewDescription.text = args.shoe.description
        }
    }
}