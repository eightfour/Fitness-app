package de.university.reutlingen.mobile.computing.fitnessapp;

public enum ErrorCodes {

    MISSING_BACK_STACK_NAME("If a fragment should be added to the back stack a name is required."),

    MISSING_PLAN_ID("When creating a Training Plan Details Fragment a training plan ID must be supplied");

    private String message;


    ErrorCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
