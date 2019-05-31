package de.university.reutlingen.mobile.computing.fitnessapp.ui.session.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

import de.university.reutlingen.mobile.computing.fitnessapp.ErrorCodes;
import de.university.reutlingen.mobile.computing.fitnessapp.R;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlan;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.detail.TrainingPlanDetailPresenter;

public class SessionDetailFragment extends Fragment implements SessionDetailView{

    private View view;
    private SessionDetailPresenter sessionDetailPresenter;

    public SessionDetailFragment(){
        //required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment. DO NOTHING ELSE HERE
        return inflater.inflate(R.layout.fragment_session_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view =view;
        if (getArguments() != null) {
            System.out.println("entered onViewCreated new SessionDetailFragment");
            this.sessionDetailPresenter = new SessionDetailPresenter(this, (TrainingPlan) getArguments().getSerializable("trainingPlan"),getArguments().getInt("selectedExerciseIndex"));
        } else {
            throw new IllegalArgumentException(ErrorCodes.MISSING_PLAN_ID.getMessage());


        }


    }
    public View getView(){
        return this.view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
