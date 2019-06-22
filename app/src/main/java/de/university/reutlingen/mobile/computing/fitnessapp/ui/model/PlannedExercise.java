package de.university.reutlingen.mobile.computing.fitnessapp.ui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlannedExercise {

    @JsonCreator
    public PlannedExercise(TrainingPlan plan,int nrOFExercise){

        this.numOfRepetitions = plan.getExerciseList().get(nrOFExercise).getNumOfRepetitions();
        this.breakDurationInSeconds =  plan.getExerciseList().get(nrOFExercise).getBreakDurationInSeconds();
        this.repetitionUnit =  plan.getExerciseList().get(nrOFExercise).getRepetitionUnit();
        this.numOfSets =  plan.getExerciseList().get(nrOFExercise).getNumOfSets();
        this.intensityLevel =  plan.getExerciseList().get(nrOFExercise).getIntensityLevel();
        this.intensityUnit =  plan.getExerciseList().get(nrOFExercise).getIntensityUnit();
        this.aimUnit =  plan.getExerciseList().get(nrOFExercise).getAimUnit();

        this.exercise = new SessionExercise(plan,nrOFExercise);

    }




    @JsonProperty("exercise")
    private SessionExercise exercise;

    @JsonProperty("numOfRepetitions")
    private String numOfRepetitions;

    @JsonProperty("breakDurationInSeconds")
    private String breakDurationInSeconds;

    @JsonProperty("repetitionUnit")
    private String repetitionUnit;

    @JsonProperty("numOfSets")
    private String numOfSets;

    @JsonProperty("intensityLevel")
    private String intensityLevel;

    @JsonProperty("intensityUnit")
    private String intensityUnit;

    @JsonProperty("aimUnit")
    private String aimUnit;



}
