package com.essabu.identity;

import com.essabu.common.internal.HttpClientWrapper;

/**
 * Client for the Identity service module.
 * Provides access to authentication, users, roles, permissions, tenants, and more.
 */
public final class IdentityClient {

    private final HttpClientWrapper http;

    private volatile AuthApi authApi;
    private volatile UserApi userApi;
    private volatile RoleApi roleApi;
    private volatile PermissionApi permissionApi;
    private volatile TenantApi tenantApi;
    private volatile CompanyApi companyApi;
    private volatile BranchApi branchApi;
    private volatile ProfileApi profileApi;
    private volatile SessionApi sessionApi;
    private volatile ApiKeyApi apiKeyApi;

    public IdentityClient(HttpClientWrapper http) {
        this.http = http;
    }

    public AuthApi auth() {
        if (authApi == null) { synchronized (this) { if (authApi == null) authApi = new AuthApi(http); } }
        return authApi;
    }

    public UserApi users() {
        if (userApi == null) { synchronized (this) { if (userApi == null) userApi = new UserApi(http); } }
        return userApi;
    }

    public RoleApi roles() {
        if (roleApi == null) { synchronized (this) { if (roleApi == null) roleApi = new RoleApi(http); } }
        return roleApi;
    }

    public PermissionApi permissions() {
        if (permissionApi == null) { synchronized (this) { if (permissionApi == null) permissionApi = new PermissionApi(http); } }
        return permissionApi;
    }

    public TenantApi tenants() {
        if (tenantApi == null) { synchronized (this) { if (tenantApi == null) tenantApi = new TenantApi(http); } }
        return tenantApi;
    }

    public CompanyApi companies() {
        if (companyApi == null) { synchronized (this) { if (companyApi == null) companyApi = new CompanyApi(http); } }
        return companyApi;
    }

    public BranchApi branches() {
        if (branchApi == null) { synchronized (this) { if (branchApi == null) branchApi = new BranchApi(http); } }
        return branchApi;
    }

    public ProfileApi profiles() {
        if (profileApi == null) { synchronized (this) { if (profileApi == null) profileApi = new ProfileApi(http); } }
        return profileApi;
    }

    public SessionApi sessions() {
        if (sessionApi == null) { synchronized (this) { if (sessionApi == null) sessionApi = new SessionApi(http); } }
        return sessionApi;
    }

    public ApiKeyApi apiKeys() {
        if (apiKeyApi == null) { synchronized (this) { if (apiKeyApi == null) apiKeyApi = new ApiKeyApi(http); } }
        return apiKeyApi;
    }
}
