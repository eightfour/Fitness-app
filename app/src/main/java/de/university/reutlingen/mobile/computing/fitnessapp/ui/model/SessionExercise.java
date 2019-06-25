package de.university.reutlingen.mobile.computing.fitnessapp.ui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SessionExercise {

    public SessionExercise() {
        // nothing to do
    }

    public SessionExercise(TrainingPlan plan, int nrOfExercise) {

        System.out.println("current Exercise: " + nrOfExercise + " current exercise id : " + plan.getExerciseList().get(nrOfExercise).getExerciseDetail().id);
        this.identifier = plan.getExerciseList().get(nrOfExercise).getExerciseDetail().id;
    }

    @JsonProperty("identifier")
    public String identifier;

}
