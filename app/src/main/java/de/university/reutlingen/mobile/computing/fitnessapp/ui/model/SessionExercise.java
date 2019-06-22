package de.university.reutlingen.mobile.computing.fitnessapp.ui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SessionExercise {

    @JsonCreator
    public SessionExercise(TrainingPlan plan, int nrOfExercise){

        System.out.println("current Exercise: " + nrOfExercise + " current exercise id : " + plan.getExerciseList().get(nrOfExercise).getId());
        this.identifier = plan.getExerciseList().get(nrOfExercise).getId();
    }

    @JsonProperty("identifier")
    private String identifier;





}
