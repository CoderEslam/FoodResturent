package com.doubleclick.foodresturent.android.Home.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.doubleclick.foodresturent.android.Adapter.CartAdapter
import com.doubleclick.foodresturent.android.R
import com.doubleclick.foodresturent.android.databinding.FragmentCartBinding
import com.doubleclick.foodresturent.android.model.Cart

class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding

    private var count: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCart.adapter = CartAdapter(
            mutableListOf(
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
                Cart(1, "name"),
            ), ::Counter
        ) { _, action ->
            when (action.actionId) {
                R.id.delete -> Toast.makeText(requireActivity(), "deleted", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    fun Counter(input: Int) {
        Log.e("TAG", "Counter: $input")
    }


}