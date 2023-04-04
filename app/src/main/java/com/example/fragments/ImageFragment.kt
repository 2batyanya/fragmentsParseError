package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

const val IMAGE_ARRAY_KEY = "imagearraykey"

class ImageFragment : Fragment() {

    private val CURRENT_IMAGE_KEY = "currentImage"
    private  var currentImageId = 0

    private lateinit var images: IntArray
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getIntArray(IMAGE_ARRAY_KEY)?.run{
            images = this
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_image, container, false).apply {
            imageView = findViewById<ImageView>(R.id.imageView).apply {
                setOnClickListener { changeImage() }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedInstanceState?.run{
            currentImageId = getInt(CURRENT_IMAGE_KEY, 0)
        }
        if(currentImageId == 0)
            changeImage()
        else
            changeImage(currentImageId)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(CURRENT_IMAGE_KEY, currentImageId)
    }

    fun changeImage() {
        currentImageId = images.random()
        changeImage(currentImageId)
    }

    fun changeImage(imageID: Int){
        imageView.setImageResource(imageID)
    }

    companion object{
        fun newInstance(images: IntArray) = ImageFragment().apply {
            arguments = Bundle().apply { putIntArray(IMAGE_ARRAY_KEY, images) }
        }
    }
}