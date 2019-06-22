package de.university.reutlingen.mobile.computing.fitnessapp.ui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Session {


    @JsonCreator
    public Session(TrainingPlan plan){
        this.plan = new SessionTrainingPlan(plan);
        this.completedExercisesList = new ArrayList<>();

        for (int currentExercise=0;currentExercise < plan.getExerciseList().size();currentExercise++){
            System.out.println();
            if(plan.getExerciseList().get(currentExercise).getExerciseIsCompleted())
                completedExercisesList.add(new CompletedExercises(plan,currentExercise));


        }

    }
    @JsonProperty("plan")
    private SessionTrainingPlan plan;

    @JsonProperty("completedExercises")
    private List<CompletedExercises> completedExercisesList;


}
