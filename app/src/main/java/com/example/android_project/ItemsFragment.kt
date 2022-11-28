package com.example.android_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.adapter.ItemAdapter
import com.example.android_project.lister.ItemListener
import com.example.android_project.model.ItemsModel


class ItemsFragment : Fragment(),ItemListener {

    private lateinit var  itemAdapter: ItemAdapter


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
        recyclerView.adapter= itemAdapter


        val listItems = listOf<ItemsModel>(
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),

            )
        itemAdapter.submitList(listItems)


        }

    override fun onClick() {
        TODO("Not yet implemented")
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        TODO("Not yet implemented")
    }
}
