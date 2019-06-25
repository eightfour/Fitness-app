package de.university.reutlingen.mobile.computing.fitnessapp.ui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({"exercise","numOfRepetitions"})
public class PlannedExercise {

    public PlannedExercise() {
        // nothing to do
    }

    public PlannedExercise(TrainingPlan plan,int nrOFExercise){

        this.numOfRepetitions =Integer.parseInt( plan.getExerciseList().get(nrOFExercise).getNumOfRepetitions());
        this.breakDurationInSeconds = Integer.parseInt( plan.getExerciseList().get(nrOFExercise).getBreakDurationInSeconds());
        this.repetitionUnit =  plan.getExerciseList().get(nrOFExercise).getRepetitionUnit();
        this.numOfSets =  Integer.parseInt(plan.getExerciseList().get(nrOFExercise).getNumOfSets());
        this.intensityLevel =  Integer.parseInt(plan.getExerciseList().get(nrOFExercise).getIntensityLevel());
        this.intensityUnit =  plan.getExerciseList().get(nrOFExercise).getIntensityUnit();
        this.aimUnit =  plan.getExerciseList().get(nrOFExercise).getAimUnit();

        this.exercise = new SessionExercise(plan,nrOFExercise);

    }




    @JsonProperty("exercise")
    public SessionExercise exercise;

    @JsonProperty("numOfRepetitions")
    public int numOfRepetitions;

    @JsonProperty("breakDurationInSeconds")
    public int breakDurationInSeconds;

    @JsonProperty("repetitionUnit")
    public String repetitionUnit;

    @JsonProperty("numOfSets")
    public int numOfSets;

    @JsonProperty("intensityLevel")
    public int intensityLevel;

    @JsonProperty("intensityUnit")
    public String intensityUnit;

    @JsonProperty("aimUnit")
    public String aimUnit;

}
