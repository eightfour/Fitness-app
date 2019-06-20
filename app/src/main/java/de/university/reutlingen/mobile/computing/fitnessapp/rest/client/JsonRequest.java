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

import de.university.reutlingen.mobile.computing.fitnessapp.security.SecurityContextHolder;

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
        headers.put("cookie", String.format("SESSION=%s", SecurityContextHolder.getContext().getCookie().getSessionIdentifier()));
        return headers;
    }

    @Override
    protected void deliverResponse(T response) {
        responseListener.onResponse(response);
    }

    protected abstract T doParseBody(String rawBody) throws IOException;
}
