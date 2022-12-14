package com.example.shoestore.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentFormBinding
import com.example.shoestore.home.ShoeViewModel
import com.example.shoestore.home.model.Shoe

class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormBinding.inflate(layoutInflater)
        binding.controller = this
        binding.shoe = Shoe("", "", "", "")

        validateForm()
        return binding.root
    }


    private fun validateForm() {
        binding.apply {

            button.isEnabled = false

            editTextName.doAfterTextChanged {
                if(it.isNullOrBlank()) {
                    editTextName.error = "Name required"
                }
                enabledButton()
            }

            editTextNumber.doAfterTextChanged {
                if(it.isNullOrBlank()) {
                    editTextNumber.error = "Size required"
                }
                enabledButton()
            }

            editTextCompany.doAfterTextChanged {
                if(it.isNullOrBlank()) {
                    editTextCompany.error = "Company required"
                }
                enabledButton()
            }

            editTextDescription.doAfterTextChanged {
                if(it.isNullOrBlank()) {
                    editTextDescription.error = "Description required"
                }
                enabledButton()
            }
        }
    }

    private fun validateName(): Boolean {
        binding.apply {
            return !editTextName.text.isNullOrBlank()
        }
    }

    private fun validateSize(): Boolean {
        binding.apply {
            return !editTextNumber.text.isNullOrBlank()
        }
    }

    private fun validateCompany(): Boolean {
        binding.apply {
            return !editTextCompany.text.isNullOrBlank()
        }
    }

    private fun validateDescription(): Boolean {
        binding.apply {
            return !editTextDescription.text.isNullOrBlank()
        }
    }

    private fun enabledButton() {
        binding.apply {
            button.isEnabled = validateName() && validateSize() && validateCompany() && validateDescription()
        }
    }

    fun submit() {
        viewModel.addShoe(binding.shoe!!)
        findNavController().popBackStack()
    }
}