package de.university.reutlingen.mobile.computing.fitnessapp.ui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SessionTrainingPlan {


    public SessionTrainingPlan(TrainingPlan plan){
        this.identifier = plan.getIdentifier();
    }

    @JsonProperty("identifier")
    private  String identifier;

}
