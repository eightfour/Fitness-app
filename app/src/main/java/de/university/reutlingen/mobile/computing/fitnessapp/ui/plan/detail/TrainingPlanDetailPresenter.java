package de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.detail;

import android.se.omapi.Session;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import de.university.reutlingen.mobile.computing.fitnessapp.R;
import de.university.reutlingen.mobile.computing.fitnessapp.rest.client.v1.TrainingPlanDetailRequest;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlan;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.TrainingPlansFragment;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.session.SessionFragment;

public class TrainingPlanDetailPresenter {

    private final TrainingPlanDetailView view;
    FloatingActionButton btnStartSessionFragment;
    private final String planId;
    private startSessionListener sessionListener;



    public TrainingPlanDetailPresenter(TrainingPlanDetailView view, String planId) {

        this.view = view;
        this.planId = planId;
        this.btnStartSessionFragment = this.view.getView().findViewById(R.id.fab_show_session_fragment);

        // Set the listener
        if (view.getContext() instanceof TrainingPlanDetailPresenter.startSessionListener){
            this.sessionListener = (TrainingPlanDetailPresenter.startSessionListener) view.getContext();
        } else {
            throw new RuntimeException(view.getContext().toString()
                    + " must implement TrainingPlanDetailPresenter.startSessionListenerx");
        }
    }

    public void onResume(){
        final RequestQueue queue = Volley.newRequestQueue(view.getContext());
        final TrainingPlanDetailRequest trainingPlanDetailRequest = new TrainingPlanDetailRequest(planId, this::displayTrainingPlan, error -> {
            System.out.println("ERROR Loading Training Plan Details");
        });
        queue.add(trainingPlanDetailRequest);

    }

    public void displayTrainingPlan(TrainingPlan trainingPlan){

       this.view.displayPlanId(trainingPlan.getIdentifier());

       //sets listener to button when user wants to start the plan
        btnStartSessionFragment.setOnClickListener(v -> {
            sessionListener.onSessionStart(this.view.getView(),trainingPlan);

        });
    }

    public interface startSessionListener {

        void onSessionStart(View view,TrainingPlan plan);

    }

}
