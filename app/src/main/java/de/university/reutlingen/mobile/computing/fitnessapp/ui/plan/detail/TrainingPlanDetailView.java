package de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.detail;

import android.content.Context;

public interface TrainingPlanDetailView {
    Context getContext();

    void displayPlanId(String identifier);
}
