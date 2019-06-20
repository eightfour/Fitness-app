package de.university.reutlingen.mobile.computing.fitnessapp.rest.client.v1;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import de.university.reutlingen.mobile.computing.fitnessapp.MainActivity;
import de.university.reutlingen.mobile.computing.fitnessapp.rest.client.JsonRequest;

public class LoginRequest extends Request<String> {

    private static final String URL = "http://" + MainActivity.BACKEND_HOSTNAME + ":" + MainActivity.BACKEND_PORT + "/fitness-app/login";

    private final String username;

    private final String password;

    private final Response.Listener<String> responseListener;

    public LoginRequest(Response.Listener<String> responseListener, Response.ErrorListener errorListener, String username, String password) {
        super(Method.POST, URL, errorListener);
        this.responseListener = responseListener;
        this.username = username;
        this.password = password;
    }

    @Override
    public byte[] getBody() {
        String bodyTemplate="username=%s&password=%s";
        final String loginRequestBody = String.format(bodyTemplate, this.username, this.password);
        return loginRequestBody.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        final Map<String, String> headers = response.headers;
        final String cookieHeader = headers.get("set-cookie");

        return Response.success(cookieHeader, null);
    }

    @Override
    protected void deliverResponse(String response) {
        responseListener.onResponse(response);
    }

    @Override
    public String getBodyContentType() {
        return super.getBodyContentType();
    }

}
