package de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.detail;

import android.content.Context;

import java.util.List;

public interface TrainingPlanDetailView {
    Context getContext();

    void displayPlanId(String identifier);

    void updateItems(String response);
}
