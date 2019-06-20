package de.university.reutlingen.mobile.computing.fitnessapp.ui.login;

import org.apache.commons.lang3.StringUtils;

public class SessionCookie {
    private String sessionIdentifier;

    private String path;

    private boolean httpOnly;

    public SessionCookie() {
        // nothing to do
    }

    public SessionCookie(String sessionIdentifier, String path, boolean httpOnly) {
        this.sessionIdentifier = sessionIdentifier;
        this.path = path;
        this.httpOnly = httpOnly;
    }

    public String getSessionIdentifier() {
        return sessionIdentifier;
    }

    public String getPath() {
        return path;
    }

    public boolean isHttpOnly() {
        return httpOnly;
    }

    public static SessionCookie build(String sessionIdentifier, String path, String httpOnly) {
        final boolean isHttpOnly = StringUtils.equals(httpOnly, "HttpOnly");
        return new SessionCookie(sessionIdentifier, path, isHttpOnly);
    }
}