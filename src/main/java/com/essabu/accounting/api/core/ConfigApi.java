package com.essabu.accounting.api.core;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.accounting.model.core.request.CreateAccountingConfigRequest;
import com.essabu.accounting.model.core.request.UpdateAccountingConfigRequest;
import com.essabu.accounting.model.core.response.AccountingConfigResponse;

import java.util.UUID;

/**
 * API client for managing config resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the config REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - update: update operation
 *
 * Base path: /api/accounting/config
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class ConfigApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/config";

    public ConfigApi(HttpClientWrapper http) {
        super(http);
    }

    public AccountingConfigResponse get(UUID companyId) {
        return http.get(BASE_PATH + "?companyId=" + companyId, AccountingConfigResponse.class);
    }

    public AccountingConfigResponse create(CreateAccountingConfigRequest request) {
        return http.post(BASE_PATH, request, AccountingConfigResponse.class);
    }

    public AccountingConfigResponse update(UUID id, UpdateAccountingConfigRequest request) {
        return http.put(BASE_PATH + "/" + id, request, AccountingConfigResponse.class);
    }
}
