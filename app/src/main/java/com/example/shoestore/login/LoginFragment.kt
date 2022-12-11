package com.example.shoestore.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.Navigation
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)

        validateLogin()
        setupCreateButton()

        return binding.root
    }

    private fun validateLogin() {
        binding.apply {

            loginButton.isEnabled = false

            editTextEmailAddress.doAfterTextChanged {
                if(it.isNullOrBlank()) {
                    editTextEmailAddress.error = "Email required"
                }
                enabledButton()
            }

            editTextPassword.doAfterTextChanged {
                if(it.isNullOrBlank()) {
                    editTextPassword.error = "Password required"
                }
                enabledButton()
            }
        }
    }

    private fun validateEmail(): Boolean {
        binding.apply {
            return !editTextEmailAddress.text.isNullOrBlank()
        }
    }

    private fun validatePassword(): Boolean {
        binding.apply {
            return !editTextPassword.text.isNullOrBlank()
        }
    }

    private fun enabledButton() {
        binding.apply {
            loginButton.isEnabled = validateEmail() && validatePassword()

            loginButton.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_welcomeFragment)
            }
        }
    }

    private fun setupCreateButton() {
        binding.apply {
            createButton.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_welcomeFragment)
            }
        }
    }
}