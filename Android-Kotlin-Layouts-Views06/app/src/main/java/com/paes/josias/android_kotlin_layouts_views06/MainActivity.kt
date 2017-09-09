package com.paes.josias.android_kotlin_layouts_views06

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun center(v:View){
        ivImage.scaleType = ImageView.ScaleType.CENTER
    }
    fun centerCrop(v:View){
        ivImage.scaleType = ImageView.ScaleType.CENTER_CROP
    }
    fun centerInside(v:View){
        ivImage.scaleType = ImageView.ScaleType.CENTER_INSIDE
    }
    fun fitCenter(v:View){
        ivImage.scaleType = ImageView.ScaleType.FIT_CENTER
    }
    fun fitStart(v:View){
        ivImage.scaleType = ImageView.ScaleType.FIT_START
    }
    fun fitEnd(v:View){
        ivImage.scaleType = ImageView.ScaleType.FIT_END
    }
    fun fitXY(v:View){
        ivImage.scaleType = ImageView.ScaleType.FIT_XY
    }
    fun matrix(v:View){
        ivImage.scaleType = ImageView.ScaleType.MATRIX
    }
    fun setOpacity(v:View){
        if(!etAlpha.text.toString().isNullOrEmpty()){
            ivImage.imageAlpha = etAlpha.text.toString().toInt()
        }
    }
    fun showImage(v:View){
        ivImage.visibility = View.VISIBLE
    }
    fun hideImage(v:View){
        ivImage.visibility = View.GONE
    }

}
