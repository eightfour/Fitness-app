package de.university.reutlingen.mobile.computing.fitnessapp.ui.session;

import android.se.omapi.Session;
import android.view.View;
import android.widget.TextView;


import de.university.reutlingen.mobile.computing.fitnessapp.R;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlan;

public class SessionPresenter {

    private TrainingPlan trainingPlan;
    private SessionView sessionView;
    private final  TextView sessionWeightValue;
    private final  TextView sessionSetsValue;
    private final  TextView sessionRepsValue;
    private final  TextView sessionBreakTimeValue;
    private final  TextView sessionExerciseName;



    public SessionPresenter(SessionView view, TrainingPlan trainingPlan){

        this.sessionView = view;
        System.out.println("session view is : " + this.sessionView.toString());
        System.out.println("session views view is : " + this.sessionView.getView().toString());
        this.trainingPlan = trainingPlan;
        sessionWeightValue = (TextView) sessionView.getView().findViewById(R.id.text_view_session_weight_value);
        sessionSetsValue = (TextView) sessionView.getView().findViewById(R.id.text_view_session_sets_value);
        sessionRepsValue = (TextView) sessionView.getView().findViewById(R.id.text_view_session_reps_value);
        sessionBreakTimeValue = (TextView) sessionView.getView().findViewById(R.id.text_view_session_break_time_value);
        sessionExerciseName = (TextView) sessionView.getView().findViewById(R.id.text_view_session_exercise_name);


        sessionExerciseName.setText(trainingPlan.getExerciseList().get(0).getExerciseDetail().getName());
        sessionWeightValue.setText(trainingPlan.getExerciseList().get(0).getIntensityLevel() + "kg");
        sessionSetsValue.setText(trainingPlan.getExerciseList().get(0).getNumOfSets());
        sessionRepsValue.setText(trainingPlan.getExerciseList().get(0).getNumOfRepetitions());
        sessionBreakTimeValue.setText(trainingPlan.getExerciseList().get(0).getBreakDurationInSeconds() + "seconds");
    }

}
