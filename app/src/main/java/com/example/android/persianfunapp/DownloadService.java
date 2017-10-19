package com.example.android.persianfunapp;
import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sanazk on 4/27/17.
 */

public class DownloadService extends IntentService {

    public static final String URL = "urlpath";
    public static final String FILENAME = "filename";

    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String urls = intent.getStringExtra(URL);
        String names = intent.getStringExtra(FILENAME);

        downloadFile(names, urls);
    }
    private void downloadFile(String fileName, String urlPath) {
        Toast.makeText(getApplicationContext(),"Download started",Toast.LENGTH_SHORT).show();
        File output = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
        if (output.exists()) {
            output.delete();
        }
        InputStream stream = null;
        FileOutputStream fos = null;
        try {
            URL downloadURL = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) downloadURL
                    .openConnection();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200)
                throw new Exception("Error in connection");
            InputStream is = conn.getInputStream();
            FileOutputStream os = new FileOutputStream(output);
            byte buffer[] = new byte[1024];
            int byteCount;
            while ((byteCount = is.read(buffer)) != -1) {
                os.write(buffer, 0, byteCount);
            }
            os.close();
            is.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy(){

        Toast.makeText(this, "Download is done", Toast.LENGTH_SHORT).show();

    }
}
