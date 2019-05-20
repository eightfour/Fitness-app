package de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.detail;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import de.university.reutlingen.mobile.computing.fitnessapp.rest.client.v1.TrainingPlanDetailRequest;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlan;

public class TrainingPlanDetailPresenter {

    private final TrainingPlanDetailView view;

    private final String planId;

    public TrainingPlanDetailPresenter(TrainingPlanDetailView view, String planId) {
        this.view = view;
        this.planId = planId;
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
    }

}
