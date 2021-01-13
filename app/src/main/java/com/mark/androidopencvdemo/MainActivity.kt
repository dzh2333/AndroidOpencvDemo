package com.mark.androidopencvdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var imageCaughtFace : Button? = null
    var imageFaceSelect : Button? = null

    var cameraCaughtSelect : Button? = null
    var cameraFaceSelect : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView(){

    }

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}
