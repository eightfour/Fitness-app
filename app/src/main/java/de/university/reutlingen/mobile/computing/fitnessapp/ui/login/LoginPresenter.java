package de.university.reutlingen.mobile.computing.fitnessapp.ui.login;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import de.university.reutlingen.mobile.computing.fitnessapp.Constants;
import de.university.reutlingen.mobile.computing.fitnessapp.rest.client.v1.LoginRequest;
import de.university.reutlingen.mobile.computing.fitnessapp.security.SecurityContextHolder;
import de.university.reutlingen.mobile.computing.fitnessapp.util.JacksonMapperWrapper;

public class LoginPresenter {

    public static final Pattern PATTERN = Pattern.compile("SESSION=([0-9a-z\\-]*);?\\s*Path=([a-zA-Z0-9\\/]*);\\s*(HTTPOnly)");
    private final LoginView view;

    private final List<LoginFragment.OnLoginListener> onLoginListeners = new ArrayList<>();

    public LoginPresenter(LoginView view) {
        this.view = view;
        this.view.init();
    }

    public void addLoginListener(LoginFragment.OnLoginListener loginListener) {
        if (!onLoginListeners.contains(loginListener)) {
            onLoginListeners.add(loginListener);
        }
    }

    public void onLogin(String username, String password) {
        final RequestQueue requestQueue = Volley.newRequestQueue(this.view.getContext());
        final LoginRequest loginRequest = new LoginRequest(
                response -> {
                    final SessionCookie sessionCookie = this.convertStringToSessionCookie(response);
                    final boolean isStoredInSharedPrefs = this.storeCookieInSharedPreferences(sessionCookie);
                    final boolean isStoreInSecurityContext = this.storeCookieInSecurityContext(sessionCookie);
                    if (isStoredInSharedPrefs && isStoreInSecurityContext) {
                        this.onLoginListeners.forEach(LoginFragment.OnLoginListener::onLogin);
                    } else {
                        throw new IllegalStateException("Could not store cookie in shared preferences or security context");
                    }
                },
                System.err::println,
                username,
                password);
        requestQueue.add(loginRequest);

    }

    private SessionCookie convertStringToSessionCookie(String cookieString) {
        final Matcher matcher = PATTERN.matcher(cookieString);
        if (matcher.find()) {
            return SessionCookie.build(matcher.group(1), matcher.group(2), matcher.group(3));
        } else {
            throw new IllegalArgumentException("Could not parse cookie");
        }
    }

    private boolean storeCookieInSharedPreferences(SessionCookie cookie) {
        final Context context = this.view.getContext();
        final SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.LOGIN_PREFERENCES, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.LOGIN_PREFERENCES_TOKEN_KEY, JacksonMapperWrapper.convertToString(cookie));
        return editor.commit();
    }

    private boolean storeCookieInSecurityContext(SessionCookie cookie) {
        return SecurityContextHolder.getContext().storeCookie(cookie);
    }

    public void removeAllListeners() {
        onLoginListeners.clear();
    }
}
