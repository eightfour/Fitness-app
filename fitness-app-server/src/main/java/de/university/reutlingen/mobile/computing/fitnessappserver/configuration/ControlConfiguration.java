package de.university.reutlingen.mobile.computing.fitnessappserver.configuration;

import de.university.reutlingen.mobile.computing.fitnessappserver.control.ExerciseService;
import de.university.reutlingen.mobile.computing.fitnessappserver.control.impl.ExerciseServiceImpl;
import de.university.reutlingen.mobile.computing.fitnessappserver.repository.ExerciseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControlConfiguration {

    @Bean
    public ExerciseService exerciseService( ExerciseRepository exerciseRepository ){
        return new ExerciseServiceImpl ( exerciseRepository );
    }
}
