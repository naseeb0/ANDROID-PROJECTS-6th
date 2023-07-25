package com.example.simpleinterst;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        ImageView imageView = findViewById(R.id.imageView);

        if (getIntent().hasExtra("imageId")) {
            int imageId = getIntent().getIntExtra("imageId", -1);
            imageView.setImageResource(imageId);
        }
    }
}
