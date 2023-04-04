package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class ImageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val images = arrayOf(
            R.drawable.celebrate,
            R.drawable.caramelapple,
            R.drawable.chocolatecaramel,
            R.drawable.godiva
        )

        return inflater.inflate(R.layout.fragment_image, container, false).apply{
            findViewById<ImageView>(R.id.imageView).setOnClickListener {
                (it as ImageView).setImageResource(images.random())
            }
        }

    }
}