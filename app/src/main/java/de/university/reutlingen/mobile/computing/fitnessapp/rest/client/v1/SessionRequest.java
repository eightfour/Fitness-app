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

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.Session;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlan;

public class SessionRequest extends Request<JSONObject>  {

    private static final String URL = "http://10.0.2.2:8090/fitness-app/api/v1/sessions";
    private TrainingPlan plan;
    private JSONObject obj = null;

    public SessionRequest(TrainingPlan plan,@Nullable Response.ErrorListener errorListener) {
        super(Method.POST,SessionRequest.URL,errorListener);
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
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {

        return null;
    }

    @Override
    protected void deliverResponse(JSONObject response) {

    }
    @Override
    public String getBodyContentType() {
        System.out.println("checking bodyContentType in SessionRequest");

        return "application/json";
    }
}
