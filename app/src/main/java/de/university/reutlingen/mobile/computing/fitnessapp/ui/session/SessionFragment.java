package de.university.reutlingen.mobile.computing.fitnessapp.ui.session;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.se.omapi.Session;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.university.reutlingen.mobile.computing.fitnessapp.ErrorCodes;
import de.university.reutlingen.mobile.computing.fitnessapp.R;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlan;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.detail.TrainingPlanDetailPresenter;


public class SessionFragment extends Fragment implements SessionView {

    private TrainingPlanDetailPresenter.startSessionListener mListener;
    private SessionPresenter sessionPresenter;

    private View view;

    public SessionFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment. DO NOTHING ELSE HERE
        return inflater.inflate(R.layout.fragment_session, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view =view;

        System.out.println("entered OnCreate SessionFragment");

        if (getArguments() != null) {
            System.out.println("getting Arguments from Fragment into Session");
            this.sessionPresenter = new SessionPresenter(this, (TrainingPlan) getArguments().getSerializable("trainingPlan"),getArguments().getInt("selectedExerciseIndex"));
        } else {
            throw new IllegalArgumentException(ErrorCodes.MISSING_PLAN_ID.getMessage());


        }

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TrainingPlanDetailPresenter.startSessionListener) {
            mListener = (TrainingPlanDetailPresenter.startSessionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement startSessionistener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public View getView(){
        return this.view;
    }


    public interface SessionExerciseListener{

       void onExerciseSelected(TrainingPlan plan,int selectedExerciseIndex);
    }
}
