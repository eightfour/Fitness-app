package de.university.reutlingen.mobile.computing.fitnessappserver.boundary.impl;

import de.university.reutlingen.mobile.computing.fitnessappserver.boundary.ExerciseManagementService;
import de.university.reutlingen.mobile.computing.fitnessappserver.control.ExerciseService;
import de.university.reutlingen.mobile.computing.fitnessappserver.model.Exercise;
import reactor.core.publisher.Flux;

public class ExerciseManagementServiceImpl implements ExerciseManagementService {

    private final ExerciseService exerciseService;

    public ExerciseManagementServiceImpl ( ExerciseService exerciseService ) {
        this.exerciseService = exerciseService;
    }

    @Override
    public Flux<Exercise> loadAll () {
        return exerciseService.findAll();
    }
}
