package com.doubleclick.foodresturent.android.Auth.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.doubleclick.foodresturent.android.R
import com.doubleclick.foodresturent.android.databinding.FragmentSignInBinding
import com.doubleclick.foodresturent.android.map.MapsActivity


class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick();

    }

    private fun onClick() {
        binding.signIn.setOnClickListener {
            startActivity(Intent(requireActivity(), MapsActivity::class.java))
        }
        binding.forgePassword.setOnClickListener {
            findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToForgetPasswordFragment())
        }
    }
}