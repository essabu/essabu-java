package com.essabu.common.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PageResponseTest {

    private PageResponse<String> createResponse(boolean first, boolean last, int page, int totalPages) {
        PageResponse<String> response = new PageResponse<>();
        response.setContent(List.of("item1", "item2"));
        response.setPage(page);
        response.setSize(20);
        response.setTotalElements(100);
        response.setTotalPages(totalPages);
        response.setFirst(first);
        response.setLast(last);
        return response;
    }

    @Test
    void firstPage_isFirstTrue() {
        PageResponse<String> response = createResponse(true, false, 0, 5);

        assertThat(response.isFirst()).isTrue();
        assertThat(response.isLast()).isFalse();
    }

    @Test
    void lastPage_isLastTrue() {
        PageResponse<String> response = createResponse(false, true, 4, 5);

        assertThat(response.isLast()).isTrue();
        assertThat(response.isFirst()).isFalse();
    }

    @Test
    void middlePage_neitherFirstNorLast() {
        PageResponse<String> response = createResponse(false, false, 2, 5);

        assertThat(response.isFirst()).isFalse();
        assertThat(response.isLast()).isFalse();
    }

    @Test
    void singlePage_isBothFirstAndLast() {
        PageResponse<String> response = createResponse(true, true, 0, 1);

        assertThat(response.isFirst()).isTrue();
        assertThat(response.isLast()).isTrue();
    }

    @Test
    void contentAccessible() {
        PageResponse<String> response = createResponse(true, false, 0, 5);

        assertThat(response.getContent()).containsExactly("item1", "item2");
        assertThat(response.getTotalElements()).isEqualTo(100);
        assertThat(response.getTotalPages()).isEqualTo(5);
    }

    @Test
    void deserializationFromJson() {
        String json = """
                {
                    "content": ["a", "b"],
                    "page": 0,
                    "size": 10,
                    "totalElements": 2,
                    "totalPages": 1,
                    "first": true,
                    "last": true
                }
                """;

        com.fasterxml.jackson.databind.JavaType type = com.essabu.common.internal.JsonMapper.instance()
                .getTypeFactory()
                .constructParametricType(PageResponse.class, String.class);

        PageResponse<String> response = com.essabu.common.internal.JsonMapper.fromJson(json, type);

        assertThat(response.getContent()).containsExactly("a", "b");
        assertThat(response.isFirst()).isTrue();
        assertThat(response.isLast()).isTrue();
        assertThat(response.getTotalElements()).isEqualTo(2);
    }

    @Test
    void unknownFieldsIgnored() {
        String json = """
                {
                    "content": [],
                    "page": 0,
                    "size": 10,
                    "totalElements": 0,
                    "totalPages": 0,
                    "first": true,
                    "last": true,
                    "unknownField": "should be ignored"
                }
                """;

        com.fasterxml.jackson.databind.JavaType type = com.essabu.common.internal.JsonMapper.instance()
                .getTypeFactory()
                .constructParametricType(PageResponse.class, String.class);

        PageResponse<String> response = com.essabu.common.internal.JsonMapper.fromJson(json, type);

        assertThat(response.getContent()).isEmpty();
    }
}
