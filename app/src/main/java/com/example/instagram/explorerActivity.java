package com.example.instagram;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class explorerActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explorer);
        bottomNavigationView=findViewById(R.id.bottom_navigation2);
        bottomNavigationView.setItemBackgroundResource(android.R.color.transparent);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else if (id == R.id.search) {
                Intent intent = new Intent(this, explorerActivity.class);
                startActivity(intent);}
            else if (id == R.id.reels) {
                Intent intent = new Intent(this, ReelActivity.class);
                startActivity(intent);}
            else if (id == R.id.profile_image) {
                Intent intent = new Intent(this, profileActivity.class);
                startActivity(intent);}



            return true;
        });


    }
}