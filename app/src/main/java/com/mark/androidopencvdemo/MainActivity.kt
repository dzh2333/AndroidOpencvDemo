package com.mark.androidopencvdemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mark.androidopencvdemo.ui.ImageCaughtFaceActivity
import org.opencv.objdetect.CascadeClassifier
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() , View.OnClickListener{

    var imageCaughtFace : Button? = null
    var imageFaceSelect : Button? = null

    var cameraCaughtFace : Button? = null
    var cameraFaceSelect : Button? = null

    var classifier : CascadeClassifier? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initClick()
    }

    private fun initView(){
        imageCaughtFace = findViewById(R.id.image_face_detection)
        imageFaceSelect = findViewById(R.id.image_face_recognition)

        cameraCaughtFace = findViewById(R.id.camera_face_detection)
        cameraFaceSelect = findViewById(R.id.camera_face_recognition)
    }

    private fun initClick(){
        imageCaughtFace!!.setOnClickListener(this)
        imageFaceSelect!!.setOnClickListener(this)
        cameraFaceSelect!!.setOnClickListener(this)
        cameraCaughtFace!!.setOnClickListener(this)
    }

    companion object {
        init {
            System.loadLibrary("native-lib")
            System.loadLibrary("opencv_java4")
        }
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.image_face_detection->{
                startActivity(object : Intent(MainActivity@this, ImageCaughtFaceActivity::class.java){})
            }
            R.id.image_face_recognition->{

            }
            R.id.image_face_detection->{

            }
            R.id.image_face_recognition->{

            }
        }
    }
}
