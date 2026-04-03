package com.essabu.compliance;

import com.essabu.common.internal.HttpClientWrapper;

/**
 * Client for the Compliance service module.
 * Provides access to audits, policies, and incidents through lazy-initialized sub-APIs.
 */
public final class ComplianceClient {

    private final HttpClientWrapper http;

    private volatile AuditApi auditApi;
    private volatile PolicyApi policyApi;
    private volatile IncidentApi incidentApi;

    public ComplianceClient(HttpClientWrapper http) {
        this.http = http;
    }

    /**
     * Access the Audit API (CRUD for audit logs).
     */
    public AuditApi audits() {
        if (auditApi == null) { synchronized (this) { if (auditApi == null) auditApi = new AuditApi(http); } }
        return auditApi;
    }

    /**
     * Access the Policy API (CRUD for compliance policies).
     */
    public PolicyApi policies() {
        if (policyApi == null) { synchronized (this) { if (policyApi == null) policyApi = new PolicyApi(http); } }
        return policyApi;
    }

    /**
     * Access the Incident API (CRUD for compliance incidents).
     */
    public IncidentApi incidents() {
        if (incidentApi == null) { synchronized (this) { if (incidentApi == null) incidentApi = new IncidentApi(http); } }
        return incidentApi;
    }
}
