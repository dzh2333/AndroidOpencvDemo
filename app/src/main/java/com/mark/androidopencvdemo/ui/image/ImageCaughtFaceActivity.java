package com.mark.androidopencvdemo.ui.image;

import android.app.Activity;
import android.graphics.Bitmap;
import android.hardware.biometrics.BiometricManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.mark.androidopencvdemo.R;
import com.mark.androidopencvdemo.app.MainApplication;
import com.mark.androidopencvdemo.util.AssetsHelper;
import com.mark.basemoudle.base.BaseActivity;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.math.BigDecimal;

public class ImageCaughtFaceActivity extends BaseActivity {

    private ImageView sourceImage, caughtImage;

    private int mAbsoluteFaceSize;

    @Override
    protected void initView() {
        sourceImage = findViewById(R.id.caught_aim_pic);
        caughtImage = findViewById(R.id.caught_pic);

        sourceImage.setImageBitmap(AssetsHelper.getBitmap("tly.jpg"));

        new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = detect(AssetsHelper.getBitmap("tly.jpg"));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        caughtImage.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }

    @Override
    protected void getData() {

    }

    public Bitmap detect(Bitmap bitmap) {
        // Bitmap转为Mat
        Mat src = new Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC4);
        Utils.bitmapToMat(bitmap, src);
        Mat srcGray = new Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC4);
        // 图像置灰
        Imgproc.cvtColor(src, srcGray, Imgproc.COLOR_BGRA2GRAY);
        float mRelativeFaceSize = 0.15f;
        if (mAbsoluteFaceSize == 0) {
            int height = srcGray.rows();
            if (Math.round(height * mRelativeFaceSize) > 0) {
                mAbsoluteFaceSize = Math.round(height * mRelativeFaceSize);
            }
        }
        MatOfRect faces = new MatOfRect();
        MainApplication.getClassifier().detectMultiScale(srcGray, faces, 1.1, 3, 0,
                    new Size(mAbsoluteFaceSize, mAbsoluteFaceSize), new Size());

        Rect[] facesArray = faces.toArray();
        Scalar faceRectColor = new Scalar(0, 255, 0, 255);
        for (Rect faceRect : facesArray)
            Imgproc.rectangle(src, faceRect.tl(), faceRect.br(), faceRectColor, 3);

        Bitmap resultImage = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(src, resultImage);
        return resultImage;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_image_caught_face;
    }
}
