package de.university.reutlingen.mobile.computing.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class LoginActivity extends AppCompatActivity{

   private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

          button = (Button)findViewById(R.id.button_login);
            button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeStart(v);
            }
        });
        }

        public void homeStart(View v){
            Intent intent = new Intent (LoginActivity.this, Home_StartActivity.class);
            startActivity(intent);

        }
}
