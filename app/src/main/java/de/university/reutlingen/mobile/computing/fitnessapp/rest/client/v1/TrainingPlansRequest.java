package de.university.reutlingen.mobile.computing.fitnessapp.rest.client.v1;

import com.android.volley.Response;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import de.university.reutlingen.mobile.computing.fitnessapp.rest.client.JsonRequest;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlanReference;

public class TrainingPlansRequest extends JsonRequest<List<TrainingPlanReference>> {

    private static final String URL = "http://10.0.2.2:8090/fitness-app/api/v1/plans";

    public TrainingPlansRequest(Response.Listener<List<TrainingPlanReference>> responseListener, Response.ErrorListener errorListener) {
        super(Method.GET, URL, responseListener, errorListener);
    }

    @Override
    protected List<TrainingPlanReference> doParseBody(String rawBody) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(rawBody, new TypeReference<List<TrainingPlanReference>>() {});
    }
}
