package com.example.android_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class ItemsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val goToDetails = view.findViewById<Button>(R.id.goToDeatail)
//        goToDetails.setOnClickListener {
//            parentFragmentManager.beginTransaction()
//                .add(R.id.activity_containter, ItemsFragment())
//                .commit()
        }
    }
