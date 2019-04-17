package de.university.reutlingen.mobile.computing.fitnessappserver.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fitness-app")
public class FitnessAppProperties {

    private boolean productionMode;

    public boolean isProductionMode () {
        return productionMode;
    }

    public void setProductionMode ( boolean productionMode ) {
        this.productionMode = productionMode;
    }
}
