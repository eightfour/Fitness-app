package de.university.reutlingen.mobile.computing.fitnessappserver.boundary;

import de.university.reutlingen.mobile.computing.fitnessappserver.model.Exercise;
import reactor.core.publisher.Flux;

public interface ExerciseManagementService {

    Flux<Exercise> loadAll ();

}
