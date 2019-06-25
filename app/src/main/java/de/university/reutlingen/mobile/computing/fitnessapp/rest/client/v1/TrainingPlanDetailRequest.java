package de.university.reutlingen.mobile.computing.fitnessapp.rest.client.v1;

import android.net.Uri;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import de.university.reutlingen.mobile.computing.fitnessapp.MainActivity;
import de.university.reutlingen.mobile.computing.fitnessapp.rest.client.JsonRequest;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlan;

public class TrainingPlanDetailRequest extends JsonRequest<TrainingPlan> {

    public TrainingPlanDetailRequest(String identifier, Response.Listener<TrainingPlan> responseListener, Response.ErrorListener errorListener) {
        super(Method.GET, buildUrl(identifier), responseListener, errorListener);

    }

    @Override
    protected TrainingPlan doParseBody(String rawBody) throws IOException {
        System.out.println("raw body is : " + rawBody);
        final ObjectMapper objectMapper = new ObjectMapper();
        TrainingPlan trainingPlan = objectMapper.readValue(rawBody, TrainingPlan.class);
        return trainingPlan;
    }

    private static String buildUrl(String identifier) {
        final Uri.Builder builder = new Uri.Builder();
        return builder.scheme("http")
                .encodedAuthority(MainActivity.BACKEND_HOSTNAME + ":" + MainActivity.BACKEND_PORT)
                .appendPath("fitness-app")
                .appendPath("api")
                .appendPath("v1")
                .appendPath("plans")
                .appendPath(identifier)
                .build()
                .toString();
    }
}
