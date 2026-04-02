package com.essabu.identity;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.identity.api.auth.AuthApi;
import com.essabu.identity.api.auth.LoginAttemptApi;
import com.essabu.identity.api.auth.SessionApi;
import com.essabu.identity.api.management.ApiKeyApi;
import com.essabu.identity.api.management.BranchApi;
import com.essabu.identity.api.management.CompanyApi;
import com.essabu.identity.api.management.CompanyGroupApi;
import com.essabu.identity.api.management.PermissionApi;
import com.essabu.identity.api.management.ProfileApi;
import com.essabu.identity.api.management.RoleApi;
import com.essabu.identity.api.management.TenantApi;
import com.essabu.identity.api.management.UserApi;

/**
 * Identity module client providing access to all Identity API endpoints.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class IdentityClient {

    private final HttpClientWrapper http;

    private volatile AuthApi authApi;
    private volatile UserApi userApi;
    private volatile ProfileApi profileApi;
    private volatile CompanyApi companyApi;
    private volatile CompanyGroupApi companyGroupApi;
    private volatile TenantApi tenantApi;
    private volatile RoleApi roleApi;
    private volatile PermissionApi permissionApi;
    private volatile BranchApi branchApi;
    private volatile ApiKeyApi apiKeyApi;
    private volatile SessionApi sessionApi;
    private volatile LoginAttemptApi loginAttemptApi;

    public IdentityClient(HttpClientWrapper http) {
        this.http = http;
    }

    public AuthApi auth() { if (authApi == null) { synchronized (this) { if (authApi == null) { authApi = new AuthApi(http); } } } return authApi; }
    public UserApi users() { if (userApi == null) { synchronized (this) { if (userApi == null) { userApi = new UserApi(http); } } } return userApi; }
    public ProfileApi profiles() { if (profileApi == null) { synchronized (this) { if (profileApi == null) { profileApi = new ProfileApi(http); } } } return profileApi; }
    public CompanyApi companies() { if (companyApi == null) { synchronized (this) { if (companyApi == null) { companyApi = new CompanyApi(http); } } } return companyApi; }
    public CompanyGroupApi companyGroups() { if (companyGroupApi == null) { synchronized (this) { if (companyGroupApi == null) { companyGroupApi = new CompanyGroupApi(http); } } } return companyGroupApi; }
    public TenantApi tenants() { if (tenantApi == null) { synchronized (this) { if (tenantApi == null) { tenantApi = new TenantApi(http); } } } return tenantApi; }
    public RoleApi roles() { if (roleApi == null) { synchronized (this) { if (roleApi == null) { roleApi = new RoleApi(http); } } } return roleApi; }
    public PermissionApi permissions() { if (permissionApi == null) { synchronized (this) { if (permissionApi == null) { permissionApi = new PermissionApi(http); } } } return permissionApi; }
    public BranchApi branches() { if (branchApi == null) { synchronized (this) { if (branchApi == null) { branchApi = new BranchApi(http); } } } return branchApi; }
    public ApiKeyApi apiKeys() { if (apiKeyApi == null) { synchronized (this) { if (apiKeyApi == null) { apiKeyApi = new ApiKeyApi(http); } } } return apiKeyApi; }
    public SessionApi sessions() { if (sessionApi == null) { synchronized (this) { if (sessionApi == null) { sessionApi = new SessionApi(http); } } } return sessionApi; }
    public LoginAttemptApi loginAttempts() { if (loginAttemptApi == null) { synchronized (this) { if (loginAttemptApi == null) { loginAttemptApi = new LoginAttemptApi(http); } } } return loginAttemptApi; }
}
