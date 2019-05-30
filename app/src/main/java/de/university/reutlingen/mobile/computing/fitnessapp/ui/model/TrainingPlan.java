package de.university.reutlingen.mobile.computing.fitnessapp.ui.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainingPlan implements Serializable {

    @JsonProperty("id")
    private String identifier;


    @JsonProperty("exerciseList")
    private List<Exercise> exerciseList;

    public TrainingPlan() {
        // empty constructor.
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }


    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }


}
