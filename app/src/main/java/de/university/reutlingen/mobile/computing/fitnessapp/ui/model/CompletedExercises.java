package de.university.reutlingen.mobile.computing.fitnessapp.ui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CompletedExercises {

    @JsonCreator
    public CompletedExercises(TrainingPlan plan, int currentExercise){


        this.plannedExercise = new PlannedExercise(plan,currentExercise);

        this.numOfRepetitions = plan.getExerciseList().get(currentExercise).getNumOfRepetitions();
        this.breakDurationInSeconds =  plan.getExerciseList().get(currentExercise).getBreakDurationInSeconds();
        this.numOfSets =  plan.getExerciseList().get(currentExercise).getNumOfSets();
        this.intensityLevel =  plan.getExerciseList().get(currentExercise).getIntensityLevel();




    }


    @JsonProperty("plannedExercise")
    private PlannedExercise plannedExercise;

    @JsonProperty("numOfRepetitions")
    private String numOfRepetitions;

    @JsonProperty("numOfSets")
    private String numOfSets;

    @JsonProperty("breakDurationInSeconds")
    private String breakDurationInSeconds;

    @JsonProperty("intensityLevel")
    private String intensityLevel;
}
