package com.example.proyectodam_m7;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class Videojuegos extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videojuegos);
        Log.d("Videojuegos", "Videojuegos activity created");
    }
}
