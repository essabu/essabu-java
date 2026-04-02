package com.essabu.project;

import com.essabu.common.internal.HttpClientWrapper;

/**
 * Client for the Project service module.
 * Provides access to projects, tasks, milestones, resource allocations, and reports.
 */
public final class ProjectClient {

    private final HttpClientWrapper http;

    private volatile ProjectApi projectApi;
    private volatile TaskApi taskApi;
    private volatile MilestoneApi milestoneApi;
    private volatile ResourceAllocationApi resourceAllocationApi;
    private volatile ReportApi reportApi;

    public ProjectClient(HttpClientWrapper http) {
        this.http = http;
    }

    public ProjectApi projects() {
        if (projectApi == null) { synchronized (this) { if (projectApi == null) projectApi = new ProjectApi(http); } }
        return projectApi;
    }

    public TaskApi tasks() {
        if (taskApi == null) { synchronized (this) { if (taskApi == null) taskApi = new TaskApi(http); } }
        return taskApi;
    }

    public MilestoneApi milestones() {
        if (milestoneApi == null) { synchronized (this) { if (milestoneApi == null) milestoneApi = new MilestoneApi(http); } }
        return milestoneApi;
    }

    public ResourceAllocationApi resourceAllocations() {
        if (resourceAllocationApi == null) { synchronized (this) { if (resourceAllocationApi == null) resourceAllocationApi = new ResourceAllocationApi(http); } }
        return resourceAllocationApi;
    }

    public ReportApi reports() {
        if (reportApi == null) { synchronized (this) { if (reportApi == null) reportApi = new ReportApi(http); } }
        return reportApi;
    }
}
