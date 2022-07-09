package com.example.glossary_of_physics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector

import android.widget.ImageView
import androidx.core.content.ContentProviderCompat.requireContext


class FormulasActivity : AppCompatActivity(){
    lateinit var screen: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulas)

        val formulas:IntArray = intArrayOf(R.drawable.kinematika1, R.drawable.dinamika, R.drawable.statika)
        var i = intent.getIntExtra("formulas", 0)
        screen = findViewById(R.id.kinematika1)
        screen.setImageResource(formulas[i])

    }

    private var mScaleFactor = 1f

    private val scaleListener = object : ScaleGestureDetector.SimpleOnScaleGestureListener() {

        override fun onScale(detector: ScaleGestureDetector): Boolean {
            mScaleFactor *= detector.scaleFactor

            // Don't let the object get too small or too large.
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 5.0f))
            screen.scaleX = mScaleFactor
            screen.scaleY = mScaleFactor
            return true
        }
    }

    private val mScaleDetector by lazy {ScaleGestureDetector(this, scaleListener)}

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        // Let the ScaleGestureDetector inspect all events.
        mScaleDetector.onTouchEvent(ev)
        return true
    }



}