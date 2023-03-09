package com.example.summer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summer.R
import com.example.summer.databinding.FragmentHomeRegistrationBinding


class HomeRegistrationFragment : Fragment() {

    private var _binding: FragmentHomeRegistrationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeRegistrationBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configDropDowm()
        navigationBackHomeList()
    }

    private fun navigationBackHomeList() {
        binding.imageBack.setOnClickListener {
            val action = HomeRegistrationFragmentDirections.actionHomeRegistrationFragmentToHomeListFragment()
            findNavController().navigate(action)
        }
    }

    private fun configDropDowm() {
        val periodos = resources.getStringArray(R.array.periodos)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, periodos)
        binding.autoCompletextView.setAdapter(arrayAdapter)
    }


}