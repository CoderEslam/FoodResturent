package com.doubleclick.foodresturent.android.liquidswipe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.doubleclick.foodresturent.android.Auth.AuthActivity
import com.doubleclick.foodresturent.android.R
import com.doubleclick.foodresturent.android.databinding.FragmentSplashBinding

private const val ARG_DOTES = "ARG_DOTES"
private const val ARG_ANIMATION = "ARG_ANIMATION"
private const val ARG_TITLE = "ARG_TITLE"
private const val ARG_POSITION = "ARG_POSITION"

class SplashFragment : Fragment() {
    private var dotes: Int? = null
    private var lotteAnimation: Int? = null
    private var position: Int? = null
    private var title: String? = null
    private lateinit var binding: FragmentSplashBinding

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dotes = it.getInt(ARG_DOTES)
            lotteAnimation = it.getInt(ARG_ANIMATION)
            position = it.getInt(ARG_POSITION)
            title = it.getString(ARG_TITLE)
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return binding.root.apply {
            background = resources.getDrawable(R.drawable.bg)
            binding.dots.setImageDrawable(resources.getDrawable(dotes!!))
            binding.lottieAnimationView.setAnimation(lotteAnimation!!)
            binding.title.text = title
            binding.title.setOnClickListener {
                startActivity(Intent(requireActivity(), AuthActivity::class.java))
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(dots: Int, anim: Int, title: String, position: Int) =
            SplashFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_DOTES, dots)
                    putInt(ARG_ANIMATION, anim)
                    putString(ARG_TITLE, title)
                    putInt(ARG_POSITION, position)
                }
            }
    }
}
