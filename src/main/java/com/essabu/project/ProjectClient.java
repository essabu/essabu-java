package com.essabu.project;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.project.api.*;

/**
 * Project module client providing access to all Project API endpoints.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class ProjectClient {

    private final HttpClientWrapper http;

    private volatile ProjectApi projectApi;
    private volatile MilestoneApi milestoneApi;
    private volatile TaskApi taskApi;
    private volatile TaskCommentApi taskCommentApi;
    private volatile ResourceAllocationApi resourceAllocationApi;
    private volatile ReportApi reportApi;

    public ProjectClient(HttpClientWrapper http) {
        this.http = http;
    }

    public ProjectApi projects() { if (projectApi == null) { synchronized (this) { if (projectApi == null) { projectApi = new ProjectApi(http); } } } return projectApi; }
    public MilestoneApi milestones() { if (milestoneApi == null) { synchronized (this) { if (milestoneApi == null) { milestoneApi = new MilestoneApi(http); } } } return milestoneApi; }
    public TaskApi tasks() { if (taskApi == null) { synchronized (this) { if (taskApi == null) { taskApi = new TaskApi(http); } } } return taskApi; }
    public TaskCommentApi taskComments() { if (taskCommentApi == null) { synchronized (this) { if (taskCommentApi == null) { taskCommentApi = new TaskCommentApi(http); } } } return taskCommentApi; }
    public ResourceAllocationApi resourceAllocations() { if (resourceAllocationApi == null) { synchronized (this) { if (resourceAllocationApi == null) { resourceAllocationApi = new ResourceAllocationApi(http); } } } return resourceAllocationApi; }
    public ReportApi reports() { if (reportApi == null) { synchronized (this) { if (reportApi == null) { reportApi = new ReportApi(http); } } } return reportApi; }
}
