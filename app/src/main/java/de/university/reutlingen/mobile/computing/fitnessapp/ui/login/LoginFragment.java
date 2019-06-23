package de.university.reutlingen.mobile.computing.fitnessapp.ui.login;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.university.reutlingen.mobile.computing.fitnessapp.R;

public class LoginFragment extends Fragment implements LoginView {

    private LoginPresenter loginPresenter;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment. DO NOTHING ELSE HERE
        return inflater.inflate(R.layout.fragment_login, container, false);

    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.loginPresenter = new LoginPresenter(this);

        if (getContext() instanceof OnLoginListener) {
            this.loginPresenter.addLoginListener((OnLoginListener) getContext());
        } else {
            throw new RuntimeException(getContext().toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

    @Override
    public void init() {
        getView().setBackgroundColor(Color.WHITE);

        final View loginBtn = getView().findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(this::onLoginClicked);
    }

    private void onLoginClicked(View clickedView) {
        if (clickedView.getId() == R.id.btn_login ){
            final String username = ((TextInputLayout) getView().findViewById(R.id.username_textInputLayout)).getEditText().getText().toString();
            final String password = ((TextInputLayout) getView().findViewById(R.id.password_textInputLayout)).getEditText().getText().toString();
            loginPresenter.onLogin(username, password);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.loginPresenter.removeAllListeners();
    }

    public interface OnLoginListener {
        void onLogin();
    }
}
