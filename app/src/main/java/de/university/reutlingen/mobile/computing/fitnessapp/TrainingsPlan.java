package de.university.reutlingen.mobile.computing.fitnessapp;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static de.university.reutlingen.mobile.computing.fitnessapp.MainActivity.LOGIN_FRAGMENT_BACKSTACK_ENTRY;


public class TrainingsPlan extends AppCompatActivity implements MainView{

    private MainPresenter mainPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("entered TrainingsPlan Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainings_plan);

        this.mainPresenter = new MainPresenter(this);
        mainPresenter.getExerciseById();
        System.out.println("mainpresenter:" + this.mainPresenter);


    }


    @Override
    public void init() {
        System.out.println("entered init in TrainingsPLanActivity");
       final TextView textViewAllExercises = findViewById(R.id.textView_AllExercises);
       System.out.println("textview created ");


    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void showLoginFragment() {

    }

    @Override
    public void hideLoginFragment() {

    }

    @Override
    public void showError(String error) {
        final TextView textViewAllExercieses = findViewById(R.id.textView_AllExercises);
        textViewAllExercieses.setText(error);
    }

    @Override
    public void showExercise(String exercise) {
        final TextView textViewAllExercieses = findViewById(R.id.textView_AllExercises);
        textViewAllExercieses.setText(exercise);


    }
}
