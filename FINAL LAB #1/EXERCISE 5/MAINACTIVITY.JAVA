package com.example.finallab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    int[] images = {R.drawable.run1, R.drawable.run2};
    int currentIndex = 0;
    ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        imageSwitcher = findViewById(R.id.imageSwitcher);
        Button btnSwap = findViewById(R.id.btnSwap);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView img = new ImageView(MainActivity.this);
                img.setScaleType(ImageView.ScaleType.FIT_CENTER);
                img.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ImageSwitcher.LayoutParams.MATCH_PARENT,
                        ImageSwitcher.LayoutParams.MATCH_PARENT));
                return img;
            }
        });

        imageSwitcher.setImageResource(images[currentIndex]);

        btnSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % images.length;
                imageSwitcher.setImageResource(images[currentIndex]);
                Toast.makeText(MainActivity.this, "Image Switched", Toast.LENGTH_SHORT).show();
            }
        });


    }
}







