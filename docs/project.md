# Project Module Reference

The Project module provides project management capabilities including projects, tasks with comments, milestones, resource allocations, and project reporting.

## Client Access

```java
EssabuClient essabu = new EssabuClient("your-api-key");
ProjectClient project = essabu.project();
```

## Available API Classes

| Class | Accessor | Description |
|-------|----------|-------------|
| `ProjectApi` | `project.projects()` | Project CRUD |
| `TaskApi` | `project.tasks()` | Tasks and task comments |
| `MilestoneApi` | `project.milestones()` | Project milestones |
| `ResourceAllocationApi` | `project.resourceAllocations()` | Resource allocation |
| `ReportApi` | `project.reports()` | Project reports |

---

## ProjectApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/project/projects` | List projects |
| `getById(UUID) -> Map` | `GET /api/project/projects/{id}` | Get project |
| `create(Map) -> Map` | `POST /api/project/projects` | Create project |
| `update(UUID, Map) -> Map` | `PUT /api/project/projects/{id}` | Update project |
| `delete(UUID) -> void` | `DELETE /api/project/projects/{id}` | Delete project |

```java
Map proj = project.projects().create(Map.of(
    "name", "Website Redesign",
    "startDate", "2026-04-01",
    "endDate", "2026-06-30",
    "budget", 50000
));
```

## TaskApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/project/tasks` | List tasks |
| `getById(UUID) -> Map` | `GET /api/project/tasks/{id}` | Get task |
| `create(Map) -> Map` | `POST /api/project/tasks` | Create task |
| `update(UUID, Map) -> Map` | `PUT /api/project/tasks/{id}` | Update task |
| `delete(UUID) -> void` | `DELETE /api/project/tasks/{id}` | Delete task |
| `listComments(UUID taskId, PageRequest) -> PageResponse<Map>` | `GET /api/project/task-comments?taskId=` | List comments |
| `createComment(Map) -> Map` | `POST /api/project/task-comments` | Create comment |
| `updateComment(UUID, Map) -> Map` | `PUT /api/project/task-comments/{id}` | Update comment |
| `deleteComment(UUID) -> void` | `DELETE /api/project/task-comments/{id}` | Delete comment |

```java
Map task = project.tasks().create(Map.of(
    "projectId", projectId, "title", "Design mockups", "assigneeId", userId
));
project.tasks().createComment(Map.of("taskId", taskId, "content", "Looking good!"));
```

## MilestoneApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/project/milestones` | List milestones |
| `getById(UUID) -> Map` | `GET /api/project/milestones/{id}` | Get milestone |
| `create(Map) -> Map` | `POST /api/project/milestones` | Create milestone |
| `update(UUID, Map) -> Map` | `PUT /api/project/milestones/{id}` | Update milestone |
| `delete(UUID) -> void` | `DELETE /api/project/milestones/{id}` | Delete milestone |

## ResourceAllocationApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/project/resource-allocations` | List allocations |
| `getById(UUID) -> Map` | `GET /api/project/resource-allocations/{id}` | Get allocation |
| `create(Map) -> Map` | `POST /api/project/resource-allocations` | Create allocation |
| `update(UUID, Map) -> Map` | `PUT /api/project/resource-allocations/{id}` | Update allocation |
| `delete(UUID) -> void` | `DELETE /api/project/resource-allocations/{id}` | Delete allocation |

```java
Map allocation = project.resourceAllocations().create(Map.of(
    "projectId", projectId,
    "userId", userId,
    "hoursPerWeek", 20,
    "startDate", "2026-04-01"
));
```

## ReportApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `getProjectSummary(Map params) -> Map` | `GET /api/project/reports/summary` | Project summary |
| `getResourceUtilization(Map params) -> Map` | `GET /api/project/reports/resource-utilization` | Resource utilization |

```java
Map summary = project.reports().getProjectSummary(Map.of("projectId", projectId));
Map utilization = project.reports().getResourceUtilization(Map.of("startDate", "2026-04-01"));
```

## Error Scenarios

| HTTP Status | Cause |
|-------------|-------|
| `400` | Invalid request data (missing project name, invalid dates) |
| `401` | Missing or expired authentication token |
| `403` | Insufficient permissions |
| `404` | Project, task, or milestone not found |
| `409` | Conflict (duplicate resource allocation) |
| `422` | Business rule violation (end date before start date) |
