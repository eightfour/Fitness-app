package de.university.reutlingen.mobile.computing.fitnessapp.ui.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Exercise {

    @JsonProperty("exercise")
    private ExerciseDetail exerciseDetail;

    @JsonProperty("numOfRepetitions")
    private String numOfRepetitions;

    @JsonProperty("breakDurationInSeconds")
    private String breakDurationInSeconds;

    @JsonProperty("numOfSets")
    private String numOfSets;

    @JsonProperty("intensityLevel")
    private String intensityLevel;

    @JsonProperty("intensityUnit")
    private String intensityUnit;

    @JsonProperty("aimUnit")
    private String aimUnit;

    @Override
    public String toString(){
        String weightOutput = "";
        if(this.intensityUnit.equals("WEIGHT")){
            weightOutput = "Weight : " + this.intensityLevel + "kg\n" + "Number of Repetitions: " + this.numOfRepetitions + "\n" + "Break : "
                    + this.breakDurationInSeconds + "\nSets : "+this.numOfSets;
        }
        return exerciseDetail.toString()+"\n" + weightOutput;
    }

    public ExerciseDetail getExerciseDetail() {
        return exerciseDetail;
    }
    public String getAimUnit() {
        return aimUnit;
    }

    public String getIntensityUnit() {
        return intensityUnit;
    }

    public String getIntensityLevel() {
        return intensityLevel;
    }

    public String getNumOfSets() {
        return numOfSets;
    }

    public String getBreakDurationInSeconds() {
        return breakDurationInSeconds;
    }

    public String getNumOfRepetitions() {
        return numOfRepetitions;
    }

}
