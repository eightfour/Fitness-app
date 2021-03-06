package de.university.reutlingen.mobile.computing.fitnessapp.rest.client.v1;

import android.support.annotation.Nullable;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import de.university.reutlingen.mobile.computing.fitnessapp.rest.client.JsonRequest;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.Session;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlan;

public class SessionRequest extends JsonRequest<String> {

    private static final String URL = "http://10.0.2.2:8090/fitness-app/api/v1/sessions";
    private TrainingPlan plan;
    private JSONObject obj = null;

    public SessionRequest(TrainingPlan plan,@Nullable Response.ErrorListener errorListener,Response.Listener responseListener) {
        super(Method.POST,SessionRequest.URL,responseListener,errorListener);
        this.plan = plan;
    }

    @Override
    public byte[] getBody() {
        System.out.println("entered GetBody in SessionRequest");
        String jsonData = null;

        Session session = new Session(this.plan);

        ObjectMapper mapper = new ObjectMapper();
        try {

            jsonData = mapper.writeValueAsString(session);


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("json Data to save a session is: " + jsonData);
        return jsonData.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String getBodyContentType() {
        System.out.println("checking bodyContentType in SessionRequest");

        return "application/json";
    }

    @Override
    protected String doParseBody(String rawBody) throws IOException {
        return null;
    }
}
