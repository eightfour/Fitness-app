package de.university.reutlingen.mobile.computing.fitnessapp.ui.session;

import android.se.omapi.Session;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import de.university.reutlingen.mobile.computing.fitnessapp.R;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlan;

public class SessionPresenter {

    private TrainingPlan trainingPlan;
    private SessionView sessionView;
    private  TextView sessionWeightValue;
    private  TextView sessionSetsValue;
    private  TextView sessionRepsValue;
    private  TextView sessionBreakTimeValue;
    private  TextView sessionExerciseName;
    private int fabChangeExerciseIndex =0;
    private FloatingActionButton fabNextExercise;
    private FloatingActionButton fabPreviousExercise;
    private Button btnIncreaseWeight;
    private Button btnDecreaseWeight;
    private Double tmpWeightValue;


    public SessionPresenter(SessionView view, TrainingPlan trainingPlan){

        this.sessionView = view;
        this.trainingPlan = trainingPlan;
        initializeLayoutComponents();
        setTextOfCurrentExercise(this.fabChangeExerciseIndex);
        tmpWeightValue = trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getIntensityLevel();





    }

    /**
     * Initializes the TextViews and the FloatingActionButtons on the Session Main Fragment
     *
     **/
    private void initializeLayoutComponents(){

        //Text Views that show Values of an Exercise
        sessionWeightValue = (TextView) sessionView.getView().findViewById(R.id.text_view_session_weight_value);
        sessionSetsValue = (TextView) sessionView.getView().findViewById(R.id.text_view_session_sets_value);
        sessionRepsValue = (TextView) sessionView.getView().findViewById(R.id.text_view_session_reps_value);
        sessionBreakTimeValue = (TextView) sessionView.getView().findViewById(R.id.text_view_session_break_time_value);
        sessionExerciseName = (TextView) sessionView.getView().findViewById(R.id.text_view_session_exercise_name);

        //Floating Action Buttons that let you navigate to another Exercise
        fabNextExercise = sessionView.getView().findViewById(R.id.fab_session_next_Exercise);
        fabNextExercise.setOnClickListener(v -> {

            fabChangeExerciseIndex +=1;
            if (fabChangeExerciseIndex == trainingPlan.getExerciseList().size())
               fabChangeExerciseIndex =0;

            setTextOfCurrentExercise(this.fabChangeExerciseIndex);
        });

        fabPreviousExercise = sessionView.getView().findViewById(R.id.fab_session_previous_Exercise);
        fabPreviousExercise.setOnClickListener(v -> {

            this.fabChangeExerciseIndex -=1;
            if(fabChangeExerciseIndex == -1)
                fabChangeExerciseIndex = trainingPlan.getExerciseList().size() -1;
            setTextOfCurrentExercise(this.fabChangeExerciseIndex);
        });

        //Buttons that let you change current Weight by + or - 2.5 kg
        btnIncreaseWeight = sessionView.getView().findViewById(R.id.btn_session_increase_weight_value);
        btnIncreaseWeight.setOnClickListener(v -> {

            tmpWeightValue += 2.5;
            sessionWeightValue.setText(Double.toString(tmpWeightValue));

        });
        btnDecreaseWeight = sessionView.getView().findViewById(R.id.btn_session_decrease_weight_value);
        btnDecreaseWeight.setOnClickListener(v -> {

           tmpWeightValue -=2.5;
            sessionWeightValue.setText(Double.toString(tmpWeightValue));
        });
    }

    /**
     * sets the Values of TextViews to the current Exercise
     * @param fabChangeExerciseIndex - int - nr of Exercise in ExerciseList of a trainings plan, you want to show
     */
    private void setTextOfCurrentExercise(int fabChangeExerciseIndex){

        sessionExerciseName.setText(trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getExerciseDetail().getName());
        sessionWeightValue.setText(Double.toString(trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getIntensityLevel()) + "kg");
        sessionSetsValue.setText(trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getNumOfSets());
        sessionRepsValue.setText(trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getNumOfRepetitions());
        sessionBreakTimeValue.setText(trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getBreakDurationInSeconds() + "seconds");

    }
}
