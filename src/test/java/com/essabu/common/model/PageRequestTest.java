package com.essabu.common.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PageRequestTest {

    @Test
    void toQueryString_withAllParams() {
        PageRequest request = PageRequest.builder()
                .page(2)
                .size(50)
                .sort("name,asc")
                .build();

        String qs = request.toQueryString();

        assertThat(qs).isEqualTo("page=2&size=50&sort=name%2Casc");
    }

    @Test
    void toQueryString_withDefaults() {
        PageRequest request = PageRequest.builder().build();

        String qs = request.toQueryString();

        assertThat(qs).isEqualTo("page=0&size=20");
        assertThat(qs).doesNotContain("sort");
    }

    @Test
    void toQueryString_sortOmittedWhenBlank() {
        PageRequest request = PageRequest.builder()
                .page(1)
                .size(10)
                .sort("")
                .build();

        String qs = request.toQueryString();

        assertThat(qs).isEqualTo("page=1&size=10");
    }

    @Test
    void toQueryString_sortOmittedWhenNull() {
        PageRequest request = PageRequest.builder()
                .page(0)
                .size(20)
                .sort(null)
                .build();

        String qs = request.toQueryString();

        assertThat(qs).doesNotContain("sort");
    }

    @Test
    void defaultValues() {
        PageRequest request = PageRequest.builder().build();

        assertThat(request.getPage()).isZero();
        assertThat(request.getSize()).isEqualTo(20);
        assertThat(request.getSort()).isEmpty();
    }

    @Test
    void toQueryString_withSpecialCharsInSort() {
        PageRequest request = PageRequest.builder()
                .page(0)
                .size(10)
                .sort("created_at,desc")
                .build();

        String qs = request.toQueryString();

        assertThat(qs).contains("sort=created_at%2Cdesc");
    }
}
