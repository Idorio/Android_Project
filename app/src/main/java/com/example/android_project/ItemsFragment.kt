package com.example.android_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.adapter.ItemAdapter
import com.example.android_project.lister.ItemListener
import com.example.android_project.model.ItemsModel


class ItemsFragment : Fragment(),ItemListener {

    private lateinit var  itemAdapter: ItemAdapter

    private val viewModel : ItemsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemAdapter = ItemAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemAdapter

        viewModel.getData()

        viewModel.items.observe(viewLifecycleOwner){ listItems ->
            itemAdapter.submitList(listItems)
        }

        viewModel.msg.observe(viewLifecycleOwner){msg ->
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()

        }
        viewModel.bundle.observe(viewLifecycleOwner){navBundle->
            val detailsFragment = DetailsFragment()
            val bundle = Bundle()
            bundle.putString("name", navBundle.name)
            bundle.putString("date",navBundle.date)
            bundle.putInt("imageView", navBundle.image)
            detailsFragment.arguments = bundle

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, detailsFragment)
                .addToBackStack("Details")
                .commit()
            viewModel.userNavigated()

        }
    }


    override fun onClick() {
        viewModel.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        viewModel.elementClicked(name, date, imageView)
    }
}
