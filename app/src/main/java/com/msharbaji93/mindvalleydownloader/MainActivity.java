package com.msharbaji93.mindvalleydownloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.msharbaji93.minddownloader.FileManager;
import com.msharbaji93.minddownloader.JobOptions;
import com.msharbaji93.minddownloader.MindValleyDownloader;
import com.msharbaji93.minddownloader.OkHttp3Downloader;
import com.msharbaji93.minddownloader.ScaleType;
import com.msharbaji93.minddownloader.Utils;

import java.io.IOException;

import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    private final String key1 = "https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5\\u0026q=80\\u0026fm=jpg\\u0026crop=faces\\u0026fit=crop\\u0026h=128\\u0026w=128\\u0026s=622a88097cf6661f84cd8942d851d9a2";
    private final String key2 = "https://www.w3schools.com/css/paris.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);

        Button button2 = (Button) findViewById(R.id.button2);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        final FileManager fileManager = new FileManager(MainActivity.this);
        fileManager.setPlaceholderResId(R.color.placeholder);
        int imgHeight = Utils.dpToPx(MainActivity.this, 300);
        int imgWidth = Utils.dpToPx(MainActivity.this, 100);
        final JobOptions options = new JobOptions();
        options.scaleType = ScaleType.CENTER_CROP;
        options.requestedHeight = imgHeight;
        options.requestedWidth = imgWidth;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileManager.load(key1, imageView, options);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileManager.load(key1, imageView2, options);
            }
        });


    }
}
