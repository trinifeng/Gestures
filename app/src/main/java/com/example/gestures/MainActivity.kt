package com.example.gestures

import android.gesture.Gesture
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    var movement: GestureDetectorCompat? = null
    lateinit var gesture: TextView
    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gesture = findViewById(R.id.number_text)
        movement = GestureDetectorCompat(this@MainActivity, this@MainActivity)
        movement?.setOnDoubleTapListener(this@MainActivity)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        movement?.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onDown(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onShowPress(p0: MotionEvent?) {

    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        number++
        gesture.text = number.toString()
        Toast.makeText(this@MainActivity, "Single Tap", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        return true
    }

    override fun onLongPress(p0: MotionEvent?) {
        number--
        gesture.text = number.toString()
        Toast.makeText(this@MainActivity, "Long Press", Toast.LENGTH_SHORT).show()
    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        number = 0
        gesture.text = number.toString()
        Toast.makeText(this@MainActivity, "Fling", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onDoubleTap(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {
        return true
    }
}