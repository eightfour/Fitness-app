package de.university.reutlingen.mobile.computing.fitnessapp;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Home_StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_start);

        System.out.println("ES GEHT!!!");
    }
}