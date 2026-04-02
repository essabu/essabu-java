package com.essabu.common.internal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * JSON serialization and deserialization utility for the Essabu SDK.
 * This is an internal component not intended for direct use by SDK consumers.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class JsonMapper {

    private static final ObjectMapper INSTANCE;

    static {
        INSTANCE = new ObjectMapper();
        INSTANCE.registerModule(new JavaTimeModule());
        INSTANCE.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        INSTANCE.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        INSTANCE.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private JsonMapper() {
    }

    public static ObjectMapper instance() {
        return INSTANCE;
    }

    public static byte[] toBytes(Object value) {
        try {
            return INSTANCE.writeValueAsBytes(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("JSON serialization error", e);
        }
    }

    public static String toJson(Object value) {
        try {
            return INSTANCE.writeValueAsString(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("JSON serialization error", e);
        }
    }

    public static <T> T fromBytes(byte[] bytes, Class<T> type) {
        try {
            return INSTANCE.readValue(bytes, type);
        } catch (Exception e) {
            throw new IllegalArgumentException("JSON deserialization error", e);
        }
    }

    public static <T> T fromJson(String json, Class<T> type) {
        try {
            return INSTANCE.readValue(json, type);
        } catch (Exception e) {
            throw new IllegalArgumentException("JSON deserialization error", e);
        }
    }

    public static <T> T fromBytes(byte[] bytes, TypeReference<T> typeRef) {
        try {
            return INSTANCE.readValue(bytes, typeRef);
        } catch (Exception e) {
            throw new IllegalArgumentException("JSON deserialization error", e);
        }
    }
}
