package de.university.reutlingen.mobile.computing.fitnessappserver.rest.v1;

import de.university.reutlingen.mobile.computing.fitnessappserver.boundary.ExerciseManagementService;
import de.university.reutlingen.mobile.computing.fitnessappserver.model.Exercise;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "/fitness-app/api/v1/exercises")
public class ExerciseControllerV1 {

    private final ExerciseManagementService delegate;

    public ExerciseControllerV1 ( ExerciseManagementService delegate ) {
        this.delegate = delegate;
    }

    @GetMapping
    public Flux<Exercise> loadAll(){
        return delegate.loadAll();
    }
}
