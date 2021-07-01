package com.example.myufms

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.myufms.R
import com.example.myufms.controller.AuthController
import com.example.myufms.databinding.FragmentSignupBinding
import com.example.myufms.model.UserSignupModel
import java.lang.Exception

val TAG = "UserSignupRequest"

class SignupFragment : Fragment() {

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!
    private val authController = AuthController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)

        binding.btnSignupCancel.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }
        binding.btnSignup.setOnClickListener { view ->
            try {
                val newUser = UserSignupModel(
                    binding.editTextSignupEmail.text.toString(),
                    binding.editTextPassword.text.toString(),
                    binding.editTextSignupCompleteName.text.toString(),
                    Integer.valueOf(binding.editTextSignupPhone.text.toString()),
                    binding.editTextSignupBirthdate.text.toString()
                )
                Log.d(TAG, "onCreateView: $newUser")
                authController.signupNewUser(newUser) {}
            } catch (e: Exception) {
                Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}