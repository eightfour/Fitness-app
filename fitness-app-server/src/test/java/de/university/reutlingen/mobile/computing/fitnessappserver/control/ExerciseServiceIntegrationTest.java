package de.university.reutlingen.mobile.computing.fitnessappserver.control;

import de.university.reutlingen.mobile.computing.fitnessappserver.model.Exercise;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith ( SpringRunner.class )
@SpringBootTest
public class ExerciseServiceIntegrationTest {

    @Autowired
    private ExerciseService exerciseService;

    @Test
    public void verifySave () {
        final Exercise exercise = new Exercise ();
        exercise.setName ( "Test exercise" );

        final Mono<Exercise> save = exerciseService.save ( exercise );
        save.subscribe ( exercise1 -> {
            assertThat ( exercise1.getName (), not ( isEmptyOrNullString () ) );
            assertThat ( exercise1.getName (), is ( "Test exercise" ) );
        } );
    }
}
