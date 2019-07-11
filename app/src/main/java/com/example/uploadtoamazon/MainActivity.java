package com.example.uploadtoamazon;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements AmazonResponse {

    Bitmap photoBitmap = null;
    int quality = 65;
    private String PreSignedURL = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Must implement the Interface

        /*Use this Code to run
            1. pass bitmap
            2. pass PreSignedUrl
            3. pass quality (0 means the lowest, 100 means the highest)*/

        /*UploadOnAmazon amz = new UploadOnAmazon(photoBitmap, PreSignedURL, quality);
        amz.res = this;
        amz.execute();*/
    }

    @Override
    public void processFinish(String responseCode) {
//        You will get response Code here, once uploading finish
//        if (responseCode == 200)
//            successfully uploaded
    }
}
