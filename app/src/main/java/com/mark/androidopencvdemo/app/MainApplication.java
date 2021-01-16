package com.mark.androidopencvdemo.app;

import android.app.Application;
import android.content.Context;

import com.mark.androidopencvdemo.R;

import org.opencv.objdetect.CascadeClassifier;
import org.opencv.osgi.OpenCVNativeLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class MainApplication extends Application {

    private static MainApplication instance;

    private static CascadeClassifier classifier;

    public static Application getContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initSDK();
    }

    private void initSDK(){
        new OpenCVNativeLoader().init();
        initClassifier();
    }

    private void initClassifier() {
        try {
            InputStream is = getResources()
                    .openRawResource(R.raw.lbpcascade_frontalface);
            File cascadeDir = getDir("cascade", Context.MODE_PRIVATE);
            File cascadeFile = new File(cascadeDir, "lbpcascade_frontalface.xml");
            FileOutputStream os = new FileOutputStream(cascadeFile);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            is.close();
            os.close();
            classifier = new CascadeClassifier(cascadeFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static CascadeClassifier getClassifier(){
        return classifier;
    }


}
