package com.essabu.hr.api.talent;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.hr.model.talent.request.UploadDocumentRequest;
import com.essabu.hr.model.talent.response.EmployeeDocumentResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * API client for managing document resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the document REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - upload: upload operation
 * - listByEmployee: list by employee operation
 * - delete: delete operation
 *
 * Base path: /api/hr/documents
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class DocumentApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/documents";

    public DocumentApi(HttpClientWrapper http) {
        super(http);
    }

    public EmployeeDocumentResponse upload(UUID employeeId, UploadDocumentRequest request) {
        Map<String, Object> parts = Map.of(
                "employeeId", employeeId.toString(),
                "documentType", request.getType(),
                "file", request.getFile()
        );
        return http.postMultipart(BASE_PATH, parts, EmployeeDocumentResponse.class);
    }

    public List<EmployeeDocumentResponse> listByEmployee(UUID employeeId) {
        return http.get(BASE_PATH + "?employeeId=" + employeeId,
                new TypeReference<>() {});
    }

    public byte[] download(UUID documentId) {
        return http.getBytes(BASE_PATH + "/" + documentId + "/download");
    }

    public void delete(UUID documentId) {
        http.delete(BASE_PATH + "/" + documentId);
    }

    public List<EmployeeDocumentResponse> getExpiring(int withinDays) {
        return http.get(BASE_PATH + "/expiring?withinDays=" + withinDays,
                new TypeReference<>() {});
    }
}
