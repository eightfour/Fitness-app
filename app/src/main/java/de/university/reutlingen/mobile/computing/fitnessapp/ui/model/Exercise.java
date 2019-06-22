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

    @JsonProperty("identifier")
    private String id;

    @JsonProperty("repetitionUnit")
    private String repetitionUnit;

    private Boolean exerciseIsCompleted = false;

    @Override
    public String toString(){
        String weightOutput = "";
        if(this.intensityUnit.equals("WEIGHT")){
            weightOutput = "Weight : " + this.intensityLevel + "kg\n" + "Number of Repetitions: " + this.numOfRepetitions + "\n" + "Break : "
                    + this.breakDurationInSeconds + "\nSets : "+this.numOfSets;
        }
        return exerciseDetail.toString()+"\n" + weightOutput;
    }

    public String getRepetitionUnit() {return repetitionUnit;}

    public Boolean getExerciseIsCompleted() {return exerciseIsCompleted;}

    public void setExerciseIsCompleted(Boolean exerciseIsCompleted) {this.exerciseIsCompleted = exerciseIsCompleted;   }

    public String getId(){return this.id; }
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

    public void setIntensityLevel(String intensityLevel){this.intensityLevel = intensityLevel;}
}
