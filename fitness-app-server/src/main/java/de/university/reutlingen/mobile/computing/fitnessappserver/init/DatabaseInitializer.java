package de.university.reutlingen.mobile.computing.fitnessappserver.init;


import de.university.reutlingen.mobile.computing.fitnessappserver.control.ExerciseService;
import de.university.reutlingen.mobile.computing.fitnessappserver.model.Exercise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class DatabaseInitializer extends AbstractInitializationService {

    private static final Logger LOGGER = LoggerFactory.getLogger ( DatabaseInitializer.class );

    private static final String EXERCISE_ONE_ID = "99a559f3-a5d0-473d-976b-80a9819baa54";

    private static final String EXERCISE_TWO_ID = "81759d10-61e4-47d3-91af-8608aed0a2a8";

    private final ExerciseService exerciseService;

    /**
     * Constructor for required fields.
     *
     * @param isProductionMode flag showing if application is running in production mode.
     */
    public DatabaseInitializer ( boolean isProductionMode, ExerciseService exerciseService ) {
        super ( isProductionMode );

        this.exerciseService = exerciseService;
    }

    @Override
    protected void createProductionData () {
        LOGGER.info ( "No production data to create" );
    }

    @Override
    protected void createDummyData () {
        final Exercise exerciseOne = new Exercise ();
        exerciseOne.setId ( EXERCISE_ONE_ID );
        exerciseOne.setName ( "Test exercise one" );
        exerciseOne.setDescription ( "Test exercise one - Description" );
        final Mono<Exercise> savedExerciseOne = exerciseService.save ( exerciseOne );

        final Exercise exerciseTwo = new Exercise ();
        exerciseTwo.setId ( EXERCISE_TWO_ID );
        exerciseTwo.setName ( "Test exercise two" );
        exerciseTwo.setDescription ( "Test exercise two - Description" );
        final Mono<Exercise> savedExerciseTwo = exerciseService.save ( exerciseTwo );

        Mono.when ( savedExerciseOne, savedExerciseTwo ).block ();

        savedExerciseOne.subscribe ( this::logExerciseInfo );
        savedExerciseTwo.subscribe ( this::logExerciseInfo );
    }

    private void logExerciseInfo ( Exercise exercise ) {
        LOGGER.debug ( String.format ( "Exercise created:\n Name: %s\n ID: %s", exercise.getName (), exercise.getId () ) );
    }
}
