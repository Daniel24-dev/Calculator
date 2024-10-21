package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class secondActivity extends AppCompatActivity {

    private boolean isHeartImage = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;




        });

        ImageView imgage = findViewById(R.id.image_heart_shape);

        imgage.setOnClickListener(v ->{
            if (isHeartImage){
                imgage.setImageResource(R.drawable.heart);

            }else {
                imgage.setImageResource(R.drawable.favorite);
            }
            isHeartImage = !isHeartImage;
        });
        TextView textView = findViewById(R.id.event_title);
        String text = getIntent().getStringExtra("result");

        textView.setText(text);




    }
    public void destroyClick(View view){
        finish();
    }
}