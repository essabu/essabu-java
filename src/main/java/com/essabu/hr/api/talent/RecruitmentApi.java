package com.essabu.hr.api.talent;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.talent.request.CompleteInterviewRequest;
import com.essabu.hr.model.talent.request.CreateApplicationRequest;
import com.essabu.hr.model.talent.request.CreateInterviewRequest;
import com.essabu.hr.model.talent.request.CreateJobPostingRequest;
import com.essabu.hr.model.talent.response.ApplicationResponse;
import com.essabu.hr.model.core.response.EmployeeResponse;
import com.essabu.hr.model.talent.response.InterviewResponse;
import com.essabu.hr.model.talent.response.JobPostingResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing recruitment resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the recruitment REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - createJobPosting: create job posting operation
 * - listJobPostings: list job postings operation
 * - publishJobPosting: publish job posting operation
 * - closeJobPosting: close job posting operation
 * - createApplication: create application operation
 * - listApplications: list applications operation
 * - advanceApplication: advance application operation
 * - rejectApplication: reject application operation
 * - hireApplication: hire application operation
 * - scheduleInterview: schedule interview operation
 * - completeInterview: complete interview operation
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class RecruitmentApi extends BaseApi {

    private static final String JOBS_PATH = "/api/hr/job-postings";
    private static final String APPS_PATH = "/api/hr/applications";
    private static final String INTERVIEWS_PATH = "/api/hr/interviews";

    public RecruitmentApi(HttpClientWrapper http) {
        super(http);
    }

    // --- Job Postings ---

    public JobPostingResponse createJobPosting(CreateJobPostingRequest request) {
        return http.post(JOBS_PATH, request, JobPostingResponse.class);
    }

    public JobPostingResponse getJobPosting(UUID id) {
        return http.get(JOBS_PATH + "/" + id, JobPostingResponse.class);
    }

    public PageResponse<JobPostingResponse> listJobPostings(PageRequest page) {
        return http.get(withPagination(JOBS_PATH, page),
                new TypeReference<PageResponse<JobPostingResponse>>() {});
    }

    public JobPostingResponse publishJobPosting(UUID id) {
        return http.put(JOBS_PATH + "/" + id + "/publish", null, JobPostingResponse.class);
    }

    public JobPostingResponse closeJobPosting(UUID id) {
        return http.put(JOBS_PATH + "/" + id + "/close", null, JobPostingResponse.class);
    }

    // --- Applications ---

    public ApplicationResponse createApplication(CreateApplicationRequest request) {
        return http.post(APPS_PATH, request, ApplicationResponse.class);
    }

    public ApplicationResponse getApplication(UUID id) {
        return http.get(APPS_PATH + "/" + id, ApplicationResponse.class);
    }

    public PageResponse<ApplicationResponse> listApplications(UUID jobPostingId, PageRequest page) {
        String path = withPagination(APPS_PATH + "?jobPostingId=" + jobPostingId, page);
        return http.get(path, new TypeReference<PageResponse<ApplicationResponse>>() {});
    }

    public ApplicationResponse advanceApplication(UUID id) {
        return http.put(APPS_PATH + "/" + id + "/advance", null, ApplicationResponse.class);
    }

    public ApplicationResponse rejectApplication(UUID id) {
        return http.put(APPS_PATH + "/" + id + "/reject", null, ApplicationResponse.class);
    }

    public EmployeeResponse hireApplication(UUID id) {
        return http.put(APPS_PATH + "/" + id + "/hire", null, EmployeeResponse.class);
    }

    // --- Interviews ---

    public InterviewResponse scheduleInterview(CreateInterviewRequest request) {
        return http.post(INTERVIEWS_PATH, request, InterviewResponse.class);
    }

    public InterviewResponse getInterview(UUID id) {
        return http.get(INTERVIEWS_PATH + "/" + id, InterviewResponse.class);
    }

    public InterviewResponse completeInterview(UUID id, CompleteInterviewRequest request) {
        return http.put(INTERVIEWS_PATH + "/" + id + "/complete", request, InterviewResponse.class);
    }
}
