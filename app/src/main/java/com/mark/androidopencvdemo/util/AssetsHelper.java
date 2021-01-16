package com.mark.androidopencvdemo.util;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.os.IResultReceiver;

import com.mark.androidopencvdemo.app.MainApplication;

import java.io.IOException;
import java.io.InputStream;

public class AssetsHelper {

    public static Bitmap getBitmap(String fileName){
        Bitmap bitmap = null;
        AssetManager assetManager = MainApplication.getContext().getAssets();
        try {
            InputStream inputStream = assetManager.open(fileName);//filename是assets目录下的图片名
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static String getText(String fileName){
        String result = "";
        try {
            InputStream is = MainApplication.getContext().getAssets().open(fileName);
            int lenght = is.available();
            byte[]  buffer = new byte[lenght];
            is.read(buffer);
            result = new String(buffer, "utf8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}


