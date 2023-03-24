package com.example.summer.ui.homeRegistration

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summer.databinding.FragmentHomeRegistrationBinding
import com.example.summer.util.CurrencyTextWatcher


class HomeRegistrationFragment : Fragment() {

    private var _binding: FragmentHomeRegistrationBinding? = null
    private val binding get() = _binding!!

    private var imagesUri: Uri? = null
    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            imagesUri = uri
            binding.imageLocalAdd.setImageURI(uri)
        }

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

        navigationBackHomeList()
        setListeners()
    }

    private fun navigationBackHomeList() {
        binding.imageBack.setOnClickListener {
            val action =
                HomeRegistrationFragmentDirections.actionHomeRegistrationFragmentToHomeListFragment()
            findNavController().navigate(action)
        }
    }

    private fun setListeners() = with(binding) {

        imageLocalAdd.setOnClickListener {
            chooseImage()
        }

        editTextPreco.run {
            addTextChangedListener(CurrencyTextWatcher(this))
        }

        buttonCadastrar.setOnClickListener {
            val nomeDoLocal = editTextNomeDoLocal.text.toString()
            val descricao = editTextDescricaoDoLocal.text.toString()
            val cep = editTextCep.text.toString()
            val numero = editTextNumeroParaContato.text.toString()
            val preco = editTextPreco.text.toString()

        }
    }

    private fun chooseImage() {
        getContent.launch("image/*")
    }
}