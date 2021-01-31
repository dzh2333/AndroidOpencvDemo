package com.mark.androidopencvdemo.ui.camera;

import android.content.Context;
import android.view.WindowManager;

import com.mark.androidopencvdemo.R;
import com.mark.basemoudle.base.BaseActivity;

import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 相机请求权限代码自己编写
 */
public class CameraCaughtActivity extends BaseActivity implements CameraBridgeViewBase.CvCameraViewListener2 {

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_camera_caught_face;
    }

    @Override
    public void onCameraViewStarted(int width, int height) {

    }

    @Override
    public void onCameraViewStopped() {

    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        return null;
    }
}
