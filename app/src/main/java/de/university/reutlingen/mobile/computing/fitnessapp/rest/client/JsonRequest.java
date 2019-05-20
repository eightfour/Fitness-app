package de.university.reutlingen.mobile.computing.fitnessapp.rest.client;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public abstract class JsonRequest<T> extends Request<T> {

    private final Response.Listener<T> responseListener;

    public JsonRequest(int method, String url, @NonNull Response.Listener<T> responseListener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.responseListener = responseListener;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String rawBody = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers, StandardCharsets.UTF_8.name())
            );
            T parsedObject = doParseBody(rawBody);
            return Response.success(parsedObject, HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (IOException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        final Map<String, String> headers = new HashMap<>();
        String creds = String.format("%s:%s", "user", "8d7910b0-7564-4ba6-9227-2f501049536f");
        String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
        headers.put("Authorization", auth);
        return headers;
    }

    @Override
    protected void deliverResponse(T response) {
        responseListener.onResponse(response);
    }

    protected abstract T doParseBody(String rawBody) throws IOException;
}
