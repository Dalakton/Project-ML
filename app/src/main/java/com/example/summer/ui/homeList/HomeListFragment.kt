package com.example.summer.ui.homeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summer.databinding.FragmentHomeListBinding


class HomeListFragment : Fragment() {

    private var _binding: FragmentHomeListBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigationScreenRegistration()
    }

    private fun navigationScreenRegistration() {
        binding.floatingActionButton.setOnClickListener {
            val action =
                HomeListFragmentDirections.actionHomeListFragmentToHomeRegistrationFragment()
            findNavController().navigate(action)

        }

    }


}