package com.essabu.einvoice.api.invoice;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.einvoice.model.invoice.request.SubmitToGovernmentRequest;
import com.essabu.einvoice.model.invoice.response.GovernmentSubmissionResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing submission resources in the Essabu E-Invoice module.
 *
 * Provides typed methods to interact with the submission REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - submit: submit operation
 * - checkStatus: check status operation
 * - list: list operation
 * - list: list operation
 *
 * Base path: /api/einvoice
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class SubmissionApi extends BaseApi {

    private static final String BASE_PATH = "/api/einvoice";

    public SubmissionApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Submits a normalized invoice to the government system.
     *
     * @param request the submission request containing the normalized invoice ID
     * @return the government submission response with status and tracking information
     */
    public GovernmentSubmissionResponse submit(SubmitToGovernmentRequest request) {
        return http.post(BASE_PATH + "/submit", request, GovernmentSubmissionResponse.class);
    }

    /**
     * Checks the current status of a government submission.
     *
     * @param submissionId the UUID of the submission to check
     * @return the updated government submission response
     */
    public GovernmentSubmissionResponse checkStatus(UUID submissionId) {
        return http.get(BASE_PATH + "/submissions/" + submissionId + "/status", GovernmentSubmissionResponse.class);
    }

    /**
     * Lists all submissions for a company with pagination.
     *
     * @param companyId the UUID of the company
     * @param page      pagination parameters
     * @return a paginated list of government submissions
     */
    public PageResponse<GovernmentSubmissionResponse> list(UUID companyId, PageRequest page) {
        String path = withParam(BASE_PATH + "/submissions", "companyId", companyId);
        path = withPagination(path, page);
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Lists all submissions for a company with default pagination.
     *
     * @param companyId the UUID of the company
     * @return a paginated list of government submissions
     */
    public PageResponse<GovernmentSubmissionResponse> list(UUID companyId) {
        return list(companyId, PageRequest.first());
    }
}
