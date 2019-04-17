package de.university.reutlingen.mobile.computing.fitnessappserver.control.impl;

import de.university.reutlingen.mobile.computing.fitnessappserver.control.ExerciseService;
import de.university.reutlingen.mobile.computing.fitnessappserver.model.Exercise;
import de.university.reutlingen.mobile.computing.fitnessappserver.repository.ExerciseRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public class ExerciseServiceImpl extends AbstractDocumentServiceImpl<Exercise, String, ExerciseRepository> implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl ( ExerciseRepository exerciseRepository ) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    protected void doSave ( Exercise document ) {
        // nothing to do
    }

    @Override
    public ExerciseRepository getRepository () {
        return this.exerciseRepository;
    }

    @Override
    public String generateId () {
        return UUID.randomUUID ().toString ();
    }

    @Override
    public Flux<Exercise> findAll () {
        return this.exerciseRepository.findAll ();
    }
}
