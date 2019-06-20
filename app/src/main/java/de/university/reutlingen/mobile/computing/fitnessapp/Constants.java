package de.university.reutlingen.mobile.computing.fitnessapp;

import de.university.reutlingen.mobile.computing.fitnessapp.ui.login.SessionCookie;
import de.university.reutlingen.mobile.computing.fitnessapp.util.JacksonMapperWrapper;

public final class Constants {

    public static final String LOGIN_PREFERENCES = "de.university.reutlingen.mobile.computing.fitnessApp.LOGIN_PREFERENCES";
    public static final String LOGIN_PREFERENCES_TOKEN_KEY = "{}";
    public static final String LOGIN_PREFERENCES_TOKEN_DEFAULT = JacksonMapperWrapper.convertToString(new SessionCookie());

    private Constants() {
        // nothing to do
    }
}
