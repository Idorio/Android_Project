package com.example.android_project.presentation.view

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.android_project.R
import com.example.android_project.databinding.FragmentItemsBinding
import com.example.android_project.databinding.FragmentSearchBinding
import com.squareup.picasso.Picasso

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.search.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                viewModel.findItem(p0?:"")
                return false
            }
        })

        viewModel.item.observe(viewLifecycleOwner){
            binding.tvDescription.text = it.description
            Picasso.get().load(Uri.parse(it.imageUrl)).into(binding.ivSearch)
        }
    }

}