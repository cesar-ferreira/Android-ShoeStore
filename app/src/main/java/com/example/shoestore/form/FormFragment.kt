package com.example.shoestore.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentFormBinding
import com.example.shoestore.home.HomeFragmentDirections
import com.example.shoestore.home.model.Shoe

class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormBinding.inflate(layoutInflater)
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

            button.setOnClickListener {
                val shoe = Shoe(name = editTextName.text.toString(), size = editTextNumber.text.toString(), company = editTextCompany.text.toString(), description = editTextDescription.text.toString())

                Navigation.findNavController(it).navigate(FormFragmentDirections.actionFormFragmentToHomeFragment(shoe))

            }
        }
    }
}