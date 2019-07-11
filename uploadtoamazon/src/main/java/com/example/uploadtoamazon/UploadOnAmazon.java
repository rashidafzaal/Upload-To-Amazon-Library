package com.example.uploadtoamazon;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class UploadOnAmazon extends AsyncTask<String, String, String> {

    private int quality = 65;
    private final String PreSignedURL;
    public AmazonResponse res = null;
    private int responseCode;
    Bitmap bmp;

    public UploadOnAmazon(Bitmap bitmap, String signedUrl, int quality) {
        this.bmp = bitmap;
        this.PreSignedURL = signedUrl;
        this.quality = quality;
    }

    @Override
    protected String doInBackground(String... strings) {

        URL url = null;
        HttpURLConnection connection = null;

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.JPEG, quality, bos);
            byte[] fileBytes = bos.toByteArray();

            url = new URL(PreSignedURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/octet-stream");

            OutputStream output = connection.getOutputStream();
            InputStream input = new ByteArrayInputStream(fileBytes);
            byte[] buffer = new byte[4096];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            output.flush();

            // Check the HTTP response code.
            responseCode = connection.getResponseCode();
            System.out.println("HTTP response code: " + connection.getResponseCode());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.valueOf(responseCode);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        res.processFinish(result);
    }
}
