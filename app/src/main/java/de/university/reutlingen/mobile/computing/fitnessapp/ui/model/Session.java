package de.university.reutlingen.mobile.computing.fitnessapp.ui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;

import java.util.ArrayList;
import java.util.List;
@JsonPropertyOrder({"plan","completedExercises"})
public class Session {

    public Session(TrainingPlan plan){
        this.sessionTrainingPlan = new SessionTrainingPlan(plan);
        this.completedExercisesList = new ArrayList<>();

        for (int currentExercise=0;currentExercise < plan.getExerciseList().size();currentExercise++){

            if(plan.getExerciseList().get(currentExercise).getExerciseIsCompleted())
                completedExercisesList.add(new CompletedExercises(plan,currentExercise));
        }

    }

    private CompletedExercises convertToCompletedExercise(Exercise exercise) {
        if (exercise.getExerciseIsCompleted()) {
            PlannedExercise plannedExercise = new PlannedExercise();

            CompletedExercises completedExercises = new CompletedExercises();
            completedExercises.breakDurationInSeconds = Integer.valueOf(exercise.getBreakDurationInSeconds());
            completedExercises.intensityLevel = Integer.valueOf(exercise.getIntensityLevel());
            completedExercises.numOfRepetitions = Integer.valueOf(exercise.getNumOfRepetitions());
            completedExercises.numOfSets = Integer.valueOf(exercise.getNumOfSets());
            completedExercises.plannedExercise = new PlannedExercise();
        }
        return null;
    }

    @JsonProperty("plan")
    public SessionTrainingPlan sessionTrainingPlan;

    @JsonProperty("completedExercises")
    public List<CompletedExercises> completedExercisesList;


}
