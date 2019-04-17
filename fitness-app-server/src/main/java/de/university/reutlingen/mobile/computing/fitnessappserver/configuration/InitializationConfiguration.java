package de.university.reutlingen.mobile.computing.fitnessappserver.configuration;

import de.university.reutlingen.mobile.computing.fitnessappserver.configuration.properties.FitnessAppProperties;
import de.university.reutlingen.mobile.computing.fitnessappserver.control.ExerciseService;
import de.university.reutlingen.mobile.computing.fitnessappserver.init.DatabaseInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializationConfiguration {

    @Bean
    public DatabaseInitializer databaseInitializer( FitnessAppProperties properties, ExerciseService exerciseService ){
        return new DatabaseInitializer (properties.isProductionMode (), exerciseService);
    }
}
