package de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.detail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.university.reutlingen.mobile.computing.fitnessapp.ErrorCodes;
import de.university.reutlingen.mobile.computing.fitnessapp.R;

/**
 * Fragment to display details of a training plan.
 */
public class TrainingPlanDetailFragment extends Fragment implements TrainingPlanDetailView{

    public static final String PLAN_ID = "plan-id";

    private TrainingPlanDetailPresenter presenter;

    public TrainingPlanDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment. DO NOTHING ELSE HERE
        return inflater.inflate(R.layout.fragment_training_plan_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            this.presenter = new TrainingPlanDetailPresenter(this, getArguments().getString(PLAN_ID));
        } else {
            throw new IllegalArgumentException(ErrorCodes.MISSING_PLAN_ID.getMessage());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.presenter.onResume();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void displayPlanId(String identifier) {
        final TextView planIdView = (TextView) getView().findViewById(R.id.plan_id_value);
        planIdView.setText(identifier);
    }
}
