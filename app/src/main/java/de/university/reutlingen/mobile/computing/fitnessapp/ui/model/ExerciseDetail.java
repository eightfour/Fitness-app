package de.university.reutlingen.mobile.computing.fitnessapp.ui.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExerciseDetail {

    @JsonProperty("identifier")
    public String id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("description")
    public String description;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
