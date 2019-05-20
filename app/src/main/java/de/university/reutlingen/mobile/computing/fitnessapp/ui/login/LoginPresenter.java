package de.university.reutlingen.mobile.computing.fitnessapp.ui.login;

import java.util.ArrayList;
import java.util.List;

public class LoginPresenter {

    private final LoginView view;

    private final List<LoginFragment.OnLoginListener> onLoginListeners = new ArrayList<>();

    public LoginPresenter(LoginView view) {
        this.view = view;
        this.view.init();
    }

    public void addLoginListener(LoginFragment.OnLoginListener loginListener){
        if(!onLoginListeners.contains(loginListener)){
            onLoginListeners.add(loginListener);
        }
    }

    public void onLogin() {
        this.onLoginListeners.forEach(LoginFragment.OnLoginListener::onLogin);
    }

    public void removeAllListeners() {
        onLoginListeners.clear();
    }
}
