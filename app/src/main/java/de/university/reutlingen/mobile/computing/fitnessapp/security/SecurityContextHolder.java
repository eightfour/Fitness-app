package de.university.reutlingen.mobile.computing.fitnessapp.security;

public final class SecurityContextHolder {

    private static SecurityContext securityContext;

    private SecurityContextHolder () {
        // prevent instantiation
    }

    public static SecurityContext getContext () {
        if (securityContext == null){
            securityContext = new SecurityContext();
        }
        return securityContext;
    }


}
