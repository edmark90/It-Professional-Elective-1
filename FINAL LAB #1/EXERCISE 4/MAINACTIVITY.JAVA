
package com.example.finallab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button btnToast;
    ImageButton btnImage;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnToast = findViewById(R.id.btnToast);
        btnImage = findViewById(R.id.btnImage);
        toggleButton = findViewById(R.id.tglButton);


        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Image Button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(toggleButton.isChecked())
                    Toast.makeText(MainActivity.this, "Toggle Button on", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Toggle Button off", Toast.LENGTH_SHORT).show();

            }
        });


    }
}






