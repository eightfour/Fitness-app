package de.university.reutlingen.mobile.computing.fitnessappserver.repository;

import de.university.reutlingen.mobile.computing.fitnessappserver.model.Exercise;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ExerciseRepository extends ReactiveMongoRepository<Exercise, String> {

    // no additional methods
}
