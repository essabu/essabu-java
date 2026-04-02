package com.essabu.hr;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for HR recruitment operations (job postings, applications, interviews).
 * Endpoint bases: /api/hr/job-postings, /api/hr/applications, /api/hr/interviews
 */
public final class RecruitmentApi extends BaseApi {

    private static final String JOB_POSTINGS = "/api/hr/job-postings";
    private static final String APPLICATIONS = "/api/hr/applications";
    private static final String INTERVIEWS = "/api/hr/interviews";

    public RecruitmentApi(HttpClientWrapper http) {
        super(http);
    }

    // -- Job Postings --

    public PageResponse<Map> listJobPostings(PageRequest pageRequest) {
        return http.get(withPagination(JOB_POSTINGS, pageRequest), pageType(Map.class));
    }

    public Map getJobPostingById(UUID id) {
        return http.get(JOB_POSTINGS + "/" + id, Map.class);
    }

    public Map createJobPosting(Map<String, Object> request) {
        return http.post(JOB_POSTINGS, request, Map.class);
    }

    public Map updateJobPosting(UUID id, Map<String, Object> request) {
        return http.put(JOB_POSTINGS + "/" + id, request, Map.class);
    }

    public void deleteJobPosting(UUID id) {
        http.delete(JOB_POSTINGS + "/" + id);
    }

    // -- Applications --

    public PageResponse<Map> listApplications(PageRequest pageRequest) {
        return http.get(withPagination(APPLICATIONS, pageRequest), pageType(Map.class));
    }

    public Map getApplicationById(UUID id) {
        return http.get(APPLICATIONS + "/" + id, Map.class);
    }

    public Map createApplication(Map<String, Object> request) {
        return http.post(APPLICATIONS, request, Map.class);
    }

    public Map updateApplication(UUID id, Map<String, Object> request) {
        return http.put(APPLICATIONS + "/" + id, request, Map.class);
    }

    public void deleteApplication(UUID id) {
        http.delete(APPLICATIONS + "/" + id);
    }

    // -- Interviews --

    public PageResponse<Map> listInterviews(PageRequest pageRequest) {
        return http.get(withPagination(INTERVIEWS, pageRequest), pageType(Map.class));
    }

    public Map getInterviewById(UUID id) {
        return http.get(INTERVIEWS + "/" + id, Map.class);
    }

    public Map createInterview(Map<String, Object> request) {
        return http.post(INTERVIEWS, request, Map.class);
    }

    public Map updateInterview(UUID id, Map<String, Object> request) {
        return http.put(INTERVIEWS + "/" + id, request, Map.class);
    }

    public void deleteInterview(UUID id) {
        http.delete(INTERVIEWS + "/" + id);
    }
}
