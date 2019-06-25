package de.university.reutlingen.mobile.computing.fitnessapp.ui.session;

import android.graphics.Color;
import android.se.omapi.Session;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import de.university.reutlingen.mobile.computing.fitnessapp.R;
import de.university.reutlingen.mobile.computing.fitnessapp.rest.client.v1.SessionRequest;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlan;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.detail.TrainingPlanDetailPresenter;

public class SessionPresenter {

    private SessionFragment.SessionExerciseListener sessionExerciseListener;
    private TrainingPlan trainingPlan;
    private SessionView sessionView;
    private  TextView sessionWeightValue;
    private  TextView sessionSetsValue;
    private  TextView sessionRepsValue;
    private  TextView sessionBreakTimeValue;
    private  TextView sessionExerciseName;
    private int fabChangeExerciseIndex ;
    private FloatingActionButton fabNextExercise;
    private FloatingActionButton fabPreviousExercise;
    private FloatingActionButton fabStartExercise;
    private Button btnIncreaseWeight;
    private Button btnDecreaseWeight;
    private FloatingActionButton fabSaveSession;



    public SessionPresenter(SessionView view, TrainingPlan trainingPlan,int selectedExerciseIndex){

        this.sessionView = view;
        this.trainingPlan = trainingPlan;
        this.fabChangeExerciseIndex = selectedExerciseIndex;
        initializeLayoutComponents();
        setTextOfCurrentExercise(this.fabChangeExerciseIndex);


        // Set the listener
        if (view.getContext() instanceof TrainingPlanDetailPresenter.startSessionListener){
            this.sessionExerciseListener = (SessionFragment.SessionExerciseListener) view.getContext();
        } else {
            throw new RuntimeException(view.getContext().toString()
                    + " must implement TrainingPlanDetailPresenter.startSessionListenerx");
        }
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
        //onclick listener : clicking on the name of an Exercise changes it´s names color to mark exercise as done
        sessionExerciseName = (TextView) sessionView.getView().findViewById(R.id.text_view_session_exercise_name);
        sessionExerciseName.setOnClickListener(v -> {
            if (!trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getExerciseIsCompleted()) {
                sessionExerciseName.setBackgroundColor(Color.GREEN);
                trainingPlan.getExerciseList().get(fabChangeExerciseIndex).setExerciseIsCompleted(true);
            }
            else{
                sessionExerciseName.setBackgroundColor(Color.TRANSPARENT);
                trainingPlan.getExerciseList().get(fabChangeExerciseIndex).setExerciseIsCompleted(false);
            }
        });

        //Floating Action Buttons that let you navigate to another Exercise or save current session
        fabSaveSession = sessionView.getView().findViewById(R.id.fab_session_save_session);
        fabSaveSession.setOnClickListener(v -> {


            RequestQueue queue = Volley.newRequestQueue(this.sessionView.getContext());
            System.out.println("FAB Save session is clicked");
            //TODO Fix SessionPresenter throwing 'Too many follow-up requests'-Exception
            SessionRequest sessionRequest = new SessionRequest(this.trainingPlan, errorListener -> {
                throw new IllegalStateException("Could not save current session, error : " + errorListener.toString());
            },responseListener -> {
                System.out.println("sessions successfully saved");
            });
            queue.add(sessionRequest);


        });
        fabNextExercise = sessionView.getView().findViewById(R.id.fab_session_next_Exercise);
        fabNextExercise.setOnClickListener(v -> {

            fabChangeExerciseIndex +=1;
            if (fabChangeExerciseIndex == trainingPlan.getExerciseList().size())
               fabChangeExerciseIndex =0;

            if (!trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getExerciseIsCompleted()) {
                sessionExerciseName.setBackgroundColor(Color.TRANSPARENT);

            }
            else {
                sessionExerciseName.setBackgroundColor(Color.GREEN);
            }

            setTextOfCurrentExercise(this.fabChangeExerciseIndex);
        });

        fabPreviousExercise = sessionView.getView().findViewById(R.id.fab_session_previous_Exercise);
        fabPreviousExercise.setOnClickListener(v -> {

            this.fabChangeExerciseIndex -=1;


            if(fabChangeExerciseIndex == -1)
                fabChangeExerciseIndex = trainingPlan.getExerciseList().size() -1;

            if (!trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getExerciseIsCompleted()) {
                sessionExerciseName.setBackgroundColor(Color.TRANSPARENT);

            }
            else{
                sessionExerciseName.setBackgroundColor(Color.GREEN);

            }
            setTextOfCurrentExercise(this.fabChangeExerciseIndex);
        });

        //button that lets you pause the exercise and display a timer
        fabStartExercise =sessionView.getView().findViewById(R.id.fab_session_start_Exercise);
        fabStartExercise.setOnClickListener(v -> {

            sessionExerciseListener.onExerciseSelected(this.trainingPlan,this.fabChangeExerciseIndex);

        });
        //Buttons that let you change current Weight by + or - 2.5 kg
        btnIncreaseWeight = sessionView.getView().findViewById(R.id.btn_session_increase_weight_value);
        btnIncreaseWeight.setOnClickListener(v -> {

           trainingPlan.getExerciseList().get(fabChangeExerciseIndex).setIntensityLevel(Integer.toString(Integer.parseInt(trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getIntensityLevel() )+ 1));
            sessionWeightValue.setText(trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getIntensityLevel() + "kg");

        });
        btnDecreaseWeight = sessionView.getView().findViewById(R.id.btn_session_decrease_weight_value);
        btnDecreaseWeight.setOnClickListener(v -> {

            trainingPlan.getExerciseList().get(fabChangeExerciseIndex).setIntensityLevel(Integer.toString(Integer.parseInt(trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getIntensityLevel() )- 1));
            sessionWeightValue.setText(trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getIntensityLevel() + "kg");

        });
    }

    /**
     * sets the Values of TextViews to the current Exercise
     * @param fabChangeExerciseIndex - int - nr of Exercise in ExerciseList of a trainings plan, you want to show
     */
    private void setTextOfCurrentExercise(int fabChangeExerciseIndex){

        sessionExerciseName.setText(trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getExerciseDetail().getName());
        sessionWeightValue.setText(trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getIntensityLevel() + "kg");
        sessionSetsValue.setText(trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getNumOfSets());
        sessionRepsValue.setText(trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getNumOfRepetitions());
        sessionBreakTimeValue.setText(trainingPlan.getExerciseList().get(fabChangeExerciseIndex).getBreakDurationInSeconds() + " Seconds");

    }
}
