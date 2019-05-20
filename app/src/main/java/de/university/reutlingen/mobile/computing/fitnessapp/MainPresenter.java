package de.university.reutlingen.mobile.computing.fitnessapp;

import android.content.Context;
import android.content.SharedPreferences;

public class MainPresenter {

    private final MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
        this.view.init();
    }

    void onResume() {
        // Verify login
        final Context context = view.getContext();
        final SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.LOGIN_PREFERENCES, Context.MODE_PRIVATE);
        final String string = sharedPreferences.getString(Constants.LOGIN_PREFERENCES_TOKEN_KEY, Constants.LOGIN_PREFERENCES_TOKEN_DEFAULT);

        this.view.showLoginFragment();
    }

    void onLogin(){
        this.view.hideLoginFragment();
    }

}
