package de.university.reutlingen.mobile.computing.fitnessappserver.init;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Defining methods to be implemented by any service that is to be run on application start up.
 */
public interface InitializationService extends ApplicationListener<ContextRefreshedEvent> {

  @Override
  default void onApplicationEvent( ContextRefreshedEvent event ) {
    doStart();
  }

  /**
   * Method to be run on application start.
   */
  void doStart ();
}
