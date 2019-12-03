package com.example.mylike

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var likeCount: Int = 0
    private var dislikeCount: Int = 0
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")
        //Initialise Shared Preferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)


        imageViewUp.setOnClickListener {
            likeCount += 1
            textViewUp.text = likeCount.toString()
        }

        imageViewDown.setOnClickListener {
            dislikeCount += 1
            textViewDown.text = dislikeCount.toString()
        }
    }

    override fun onStart() {
        Log.d("MainActivity", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity", "onResume")

        //Retrieve the stored values
        likeCount = sharedPreferences.getInt(getString(R.string.like), 0)
        dislikeCount = sharedPreferences.getInt(getString(R.string.dislike), 0)

        textViewUp.text = likeCount.toString()
        textViewDown.text = dislikeCount.toString()

        super.onResume()
    }

    override fun onStop() {
        Log.d("MainActivity", "onStop")
        super.onStop()
    }

    override fun onPause() {
        with(sharedPreferences.edit()){
            putInt(getString(R.string.like),likeCount)
            putInt(getString(R.string.dislike),dislikeCount)
            commit()
        }
        Log.d("MainActivity", "onPause")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy")
        super.onDestroy()
    }
}
