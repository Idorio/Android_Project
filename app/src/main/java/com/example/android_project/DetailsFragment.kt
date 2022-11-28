package com.example.android_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsName = view.findViewById<TextView>(R.id.textViewOne)
        val detailsDate = view.findViewById<TextView>(R.id.textViewTwo)
        val detailsImage = view.findViewById<ImageView>(R.id.apple)

        val bundle = arguments
        bundle?.let { safeBundle ->
            val name = safeBundle.getString("name")
            val date = safeBundle.getString("date")
            val image = safeBundle.getInt("imageview")

            detailsDate.text = date
            detailsImage.setBackgroundResource(image)
            detailsName.text = name


        }


    }
}