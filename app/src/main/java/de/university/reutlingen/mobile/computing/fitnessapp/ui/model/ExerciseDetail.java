package de.university.reutlingen.mobile.computing.fitnessapp.ui.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExerciseDetail {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @Override
    public String toString(){
        return name+"\n"+description;
    }


    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
