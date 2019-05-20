package de.university.reutlingen.mobile.computing.fitnessapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Base64;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainPresenter {

    private final MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
        System.out.println("created MainPresenter with view : " + this.view);
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


    void getExerciseById() {

        final RequestQueue queue = Volley.newRequestQueue(view.getContext());
        String url = "http://10.0.2.2:8090/fitness-app/api/v1/exercises/b3bc7c26-7d6a-488d-b45f-e29609d83e15";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    this.view.showExercise("Exercise: " + response);
                },
                error -> this.view.showError("Error: " + error.getMessage())) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> headers = new HashMap<>();
                String creds = String.format("%s:%s", "user", "8d7910b0-7564-4ba6-9227-2f501049536f");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                headers.put("Authorization", auth);
                return headers;
            }
        };
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }


    void getAllExercises() {

        System.out.println("view content:" + view.getContext());

        final RequestQueue queue = Volley.newRequestQueue(view.getContext());
        String url = "http://10.0.2.2:8090/fitness-app/api/v1/exercises/plans/";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    this.view.showExercise("Exercise: " + response);

                },
                error -> this.view.showError("Error: " + error.getMessage())) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> headers = new HashMap<>();
                String creds = String.format("%s:%s", "user", "8d7910b0-7564-4ba6-9227-2f501049536f");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                headers.put("Authorization", auth);
                return headers;
            }
        };
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
