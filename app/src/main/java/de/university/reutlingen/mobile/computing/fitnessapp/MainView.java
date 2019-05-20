package de.university.reutlingen.mobile.computing.fitnessapp;

import android.content.Context;

public interface MainView {

    /**
     * Initialize the view controlled by the presenter.
     */
    void init();

    Context getContext();

    void showLoginFragment();

    void hideLoginFragment();
}
