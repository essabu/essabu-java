package com.essabu.common.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JsonMapperTest {

    @Test
    void instance_returnsNonNull() {
        assertThat(JsonMapper.instance()).isNotNull();
    }

    @Test
    void instance_returnsSameInstance() {
        ObjectMapper first = JsonMapper.instance();
        ObjectMapper second = JsonMapper.instance();

        assertThat(first).isSameAs(second);
    }

    @Test
    void serializeMap() {
        Map<String, Object> data = Map.of("name", "test", "count", 42);
        String json = JsonMapper.toJson(data);

        assertThat(json).contains("\"name\"");
        assertThat(json).contains("\"test\"");
        assertThat(json).contains("\"count\"");
        assertThat(json).contains("42");
    }

    @Test
    void deserializeMap() {
        @SuppressWarnings("unchecked")
        Map<String, Object> result = JsonMapper.fromJson("{\"name\":\"test\",\"value\":123}", Map.class);

        assertThat(result).containsEntry("name", "test");
        assertThat(result).containsEntry("value", 123);
    }

    @Test
    void serializeLocalDate() {
        record DateHolder(LocalDate date) {}
        DateHolder holder = new DateHolder(LocalDate.of(2024, 6, 15));

        String json = JsonMapper.toJson(holder);

        assertThat(json).contains("\"2024-06-15\"");
    }

    @Test
    void deserializeLocalDate() {
        record DateHolder(LocalDate date) {}
        DateHolder result = JsonMapper.fromJson("{\"date\":\"2024-06-15\"}", DateHolder.class);

        assertThat(result.date()).isEqualTo(LocalDate.of(2024, 6, 15));
    }

    @Test
    void serializeLocalDateTime() {
        record DateTimeHolder(LocalDateTime dateTime) {}
        DateTimeHolder holder = new DateTimeHolder(LocalDateTime.of(2024, 6, 15, 10, 30, 0));

        String json = JsonMapper.toJson(holder);

        assertThat(json).contains("2024-06-15");
        assertThat(json).contains("10:30");
    }

    @Test
    void serializeInstant() {
        record InstantHolder(Instant ts) {}
        InstantHolder holder = new InstantHolder(Instant.parse("2024-06-15T10:30:00Z"));

        String json = JsonMapper.toJson(holder);

        assertThat(json).contains("2024-06-15");
    }

    @Test
    void deserializeInstant() {
        record InstantHolder(Instant ts) {}
        InstantHolder result = JsonMapper.fromJson("{\"ts\":\"2024-06-15T10:30:00Z\"}", InstantHolder.class);

        assertThat(result.ts()).isEqualTo(Instant.parse("2024-06-15T10:30:00Z"));
    }

    @Test
    void nullValuesExcluded() {
        record NullableHolder(String name, String description) {}
        NullableHolder holder = new NullableHolder("test", null);

        String json = JsonMapper.toJson(holder);

        assertThat(json).contains("\"name\"");
        assertThat(json).doesNotContain("\"description\"");
    }

    @Test
    void unknownPropertiesIgnored() {
        record SimpleHolder(String name) {}
        // JSON has extra field "extra" not present in SimpleHolder
        SimpleHolder result = JsonMapper.fromJson("{\"name\":\"test\",\"extra\":\"value\"}", SimpleHolder.class);

        assertThat(result.name()).isEqualTo("test");
    }

    @Test
    void invalidJson_throwsIllegalArgumentException() {
        assertThatThrownBy(() -> JsonMapper.fromJson("not-json", Map.class))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Failed to deserialize");
    }

    @Test
    void invalidObject_throwsIllegalArgumentException() {
        // InputStream is not serializable to JSON
        assertThatThrownBy(() -> JsonMapper.toJson(new Object() {
            @SuppressWarnings("unused")
            public Object getSelf() { return this; }
        })).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Failed to serialize");
    }
}
