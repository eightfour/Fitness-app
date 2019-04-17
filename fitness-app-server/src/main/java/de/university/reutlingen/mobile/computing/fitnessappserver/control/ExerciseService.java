package de.university.reutlingen.mobile.computing.fitnessappserver.control;

import de.university.reutlingen.mobile.computing.fitnessappserver.model.Exercise;
import de.university.reutlingen.mobile.computing.fitnessappserver.repository.ExerciseRepository;
import reactor.core.publisher.Flux;

public interface ExerciseService extends AbstractDocumentService<Exercise, String, ExerciseRepository> {

    Flux<Exercise> findAll ();
}
