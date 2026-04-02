package com.essabu.accounting;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for journal and journal entry operations.
 * Endpoint bases: /api/accounting/journals, /api/accounting/journal-entries
 */
public final class JournalApi extends BaseApi {

    private static final String JOURNALS = "/api/accounting/journals";
    private static final String ENTRIES = "/api/accounting/journal-entries";

    public JournalApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(JOURNALS, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) {
        return http.get(JOURNALS + "/" + id, Map.class);
    }

    public Map create(Map<String, Object> request) {
        return http.post(JOURNALS, request, Map.class);
    }

    public Map update(UUID id, Map<String, Object> request) {
        return http.put(JOURNALS + "/" + id, request, Map.class);
    }

    public void delete(UUID id) {
        http.delete(JOURNALS + "/" + id);
    }

    // -- Journal Entries --

    public PageResponse<Map> listEntries(PageRequest pageRequest) {
        return http.get(withPagination(ENTRIES, pageRequest), pageType(Map.class));
    }

    public Map getEntryById(UUID id) {
        return http.get(ENTRIES + "/" + id, Map.class);
    }

    public Map createEntry(Map<String, Object> request) {
        return http.post(ENTRIES, request, Map.class);
    }

    public Map updateEntry(UUID id, Map<String, Object> request) {
        return http.put(ENTRIES + "/" + id, request, Map.class);
    }

    public void deleteEntry(UUID id) {
        http.delete(ENTRIES + "/" + id);
    }
}
