package de.university.reutlingen.mobile.computing.fitnessappserver.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class defining behaviour for {@link InitializationService}.
 */
public abstract class AbstractInitializationService implements InitializationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractInitializationService.class);

  private final boolean isProductionMode;

  /**
   * Constructor for required fields.
   *
   * @param isProductionMode flag showing if application is running in production mode.
   */
  protected AbstractInitializationService(boolean isProductionMode) {
    this.isProductionMode = isProductionMode;
  }

  @Override
  public void doStart() {
    LOGGER.info("Running on a {} system", System.getProperty("os.arch"));
    if (this.isProductionMode) {
      LOGGER.info("Application is running in production mode");
      createProductionData();
    } else {
      LOGGER.info("Application is running non production mode");
      createDummyData();
    }
  }

  /**
   * Create the initial production data.
   */
  protected abstract void createProductionData();

  /**
   * Create the dummy data.
   */
  protected abstract void createDummyData();
}