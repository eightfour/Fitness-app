package de.university.reutlingen.mobile.computing.fitnessapp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.stream.Stream;

public final class JacksonMapperWrapper {

    public static String convertToString (Object object){
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Could not convert object to JSON String.", e);
        }
    }
}
