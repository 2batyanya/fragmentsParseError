package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dessert_images = intArrayOf(
            R.drawable.celebrate,
            R.drawable.caramelapple,
            R.drawable.chocolatecaramel,
            R.drawable.godiva
        )

        val fragment1 = ImageFragment.newInstance(dessert_images)

        val desert_images = intArrayOf(
            R.drawable.desert_iso,
            R.drawable.desert_khali,
            R.drawable.desert_muscat,
        )

        val fragment2 = ImageFragment.newInstance(desert_images)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.imageFragmentContainer1, fragment1)
            .add(R.id.imageFragmentContainer2, fragment2)
            .commit()

        findViewById<Button>(R.id.changeButton).setOnClickListener {
            fragment1.changeImage()
            fragment2.changeImage()
        }
    }
}