package com.example.shoestore.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentInstructionBinding
import com.example.shoestore.home.model.Shoe

class InstructionFragment : Fragment() {

    private lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInstructionBinding.inflate(layoutInflater)
        binding.controller = this


//        binding.buttonNext.setOnClickListener {
//                Navigation.findNavController(it).navigate(InstructionFragmentDirections.actionInstructionFragmentToHomeFragment(shoe))
//        }
        return binding.root
    }

    fun navigateToHome() {
        val shoe: Shoe = Shoe(name = "Sapato 13", description = "Descrição 13", size = "1.0", company = "Empresa 13")

        findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToHomeFragment(shoe))
    }
}