package com.essabu.common.internal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Centralized Jackson ObjectMapper configuration for the SDK.
 * Provides a singleton, pre-configured mapper used by all HTTP operations.
 */
public final class JsonMapper {

    private static final ObjectMapper INSTANCE;

    static {
        INSTANCE = new ObjectMapper();
        INSTANCE.registerModule(new JavaTimeModule());
        INSTANCE.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        INSTANCE.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        INSTANCE.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    private JsonMapper() {
    }

    /**
     * Returns the shared ObjectMapper instance.
     */
    public static ObjectMapper instance() {
        return INSTANCE;
    }

    /**
     * Serialize an object to a JSON string.
     */
    public static String toJson(Object value) {
        try {
            return INSTANCE.writeValueAsString(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to serialize object to JSON", e);
        }
    }

    /**
     * Deserialize a JSON string into the given type.
     */
    public static <T> T fromJson(String json, Class<T> type) {
        try {
            return INSTANCE.readValue(json, type);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to deserialize JSON to " + type.getSimpleName(), e);
        }
    }

    /**
     * Deserialize a JSON string using a JavaType (for generics like PageResponse).
     */
    public static <T> T fromJson(String json, com.fasterxml.jackson.databind.JavaType type) {
        try {
            return INSTANCE.readValue(json, type);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to deserialize JSON", e);
        }
    }
}
