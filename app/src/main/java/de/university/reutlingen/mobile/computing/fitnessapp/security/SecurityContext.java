package de.university.reutlingen.mobile.computing.fitnessapp.security;

import org.apache.commons.lang3.StringUtils;

import de.university.reutlingen.mobile.computing.fitnessapp.ui.login.SessionCookie;

public final class SecurityContext {
    private SessionCookie cookie;

    public SessionCookie getCookie() {
        return cookie;
    }

    public boolean storeCookie(SessionCookie sessionCookie) {
        validate(sessionCookie);
        this.cookie = sessionCookie;
        return true;
    }

    private void validate(SessionCookie sessionCookie) {
        if (sessionCookie == null) {
            throw new IllegalArgumentException("Can not store a session that is null in Security Context");
        }
        if (StringUtils.isBlank(sessionCookie.getPath())) {
            throw new IllegalArgumentException("Can not store a session in the Security Context with an empty or blank path");
        }
        if (StringUtils.isBlank(sessionCookie.getSessionIdentifier())) {
            throw new IllegalArgumentException("Can not store a session in the Security Context with an empty or blank session identifier");
        }
    }
}