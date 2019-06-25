package de.university.reutlingen.mobile.computing.fitnessapp.ui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;
@JsonPropertyOrder({"plannedExercise","numOfRepetitions",""})
public class CompletedExercises {


    public CompletedExercises () {
        // nothing to do
    }

    public CompletedExercises(TrainingPlan plan, int currentExercise){
        this.plannedExercise = new PlannedExercise(plan,currentExercise);
        this.numOfRepetitions = Integer.parseInt(plan.getExerciseList().get(currentExercise).getNumOfRepetitions());
        this.breakDurationInSeconds = Integer.parseInt(plan.getExerciseList().get(currentExercise).getBreakDurationInSeconds());
        this.numOfSets =  Integer.parseInt(plan.getExerciseList().get(currentExercise).getNumOfSets());
        this.intensityLevel = Integer.parseInt(plan.getExerciseList().get(currentExercise).getIntensityLevel());
    }


    @JsonProperty("plannedExercise")
    public PlannedExercise plannedExercise;

    @JsonProperty("numOfRepetitions")
    public int numOfRepetitions;

    @JsonProperty("numOfSets")
    public int numOfSets;

    @JsonProperty("breakDurationInSeconds")
    public int breakDurationInSeconds;

    @JsonProperty("intensityLevel")
    public int intensityLevel;
}
