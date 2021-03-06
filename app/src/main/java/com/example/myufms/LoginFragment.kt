package com.example.myufms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myufms.databinding.ActivityMainBinding
import com.example.myufms.databinding.FragmentLoginBinding

private var _binding: FragmentLoginBinding? = null
private val binding get() = _binding!!


class LoginFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.btnNavigateToSignup.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}