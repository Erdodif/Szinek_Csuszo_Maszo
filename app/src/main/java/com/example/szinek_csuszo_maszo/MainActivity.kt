package com.example.szinek_csuszo_maszo

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.annotation.RequiresApi
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    lateinit var sliderRed : RangeSlider
    lateinit var sliderGreen : RangeSlider
    lateinit var sliderBlue : RangeSlider
    lateinit var textView : TextView
    lateinit var layOut : RelativeLayout
    lateinit var borderRight : View
    lateinit var borderLeft : View
    lateinit var borderTop : View
    lateinit var borderBottom : View
    lateinit var szines : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        sliderRed.addOnChangeListener { _, _, _ ->
            setColor()
        }
        sliderGreen.addOnChangeListener { _, _, _ ->
            setColor()
        }
        sliderBlue.addOnChangeListener { _, _, _ ->
            setColor()
        }
    }

    private fun init()
    {
        sliderRed = findViewById(R.id.sliderRed)
        sliderGreen = findViewById(R.id.sliderGreen)
        sliderBlue = findViewById(R.id.sliderBlue)
        textView = findViewById(R.id.textView)
        layOut = findViewById(R.id.layOut)
        borderRight = findViewById(R.id.borderRight)
        borderLeft = findViewById(R.id.borderLeft)
        borderTop = findViewById(R.id.borderTop)
        borderBottom = findViewById(R.id.borderBottom)
        szines = findViewById(R.id.szines)
    }

    fun setColor()
    {
        var red = sliderRed.values[0].toInt()
        var green = sliderGreen.values[0].toInt()
        var blue = sliderBlue.values[0].toInt()
        szines.setBackgroundColor(Color.rgb(red,green,blue))
        textView.text= "(${red},${green},${blue})"
        if (red < 150 && green < 150 && blue < 150)
        {
            textView.setTextColor(Color.WHITE)
            setBorderColor(Color.WHITE)
        }
        else
        {
            textView.setTextColor(Color.BLACK)
            setBorderColor(Color.BLACK)
        }
    }
    fun setBorderColor(color: Int)
    {
        borderRight.setBackgroundColor(color)
        borderLeft.setBackgroundColor(color)
        borderTop.setBackgroundColor(color)
        borderBottom.setBackgroundColor(color)
    }
}