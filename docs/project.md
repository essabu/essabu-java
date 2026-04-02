# Project Module Reference

The Project module provides project management capabilities including projects, tasks with comments, milestones, resource allocations, and project reporting.

## Client Access

Initialize the Project client by calling `project()` on your Essabu instance. The client is lazily created on first access and cached for subsequent calls. Requires an API key with project module permissions; otherwise all operations will throw `ForbiddenException`.

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

Create a new project with a `name`, `startDate`, optional `endDate`, and optional `budget`. The project is created in a "planning" status and can be updated to "active" once resources are allocated. Returns the created project with its generated UUID and timestamps. Throws `ValidationException` if the end date is before the start date.

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

Create a task within a project by providing the `projectId`, a `title`, and optionally an `assigneeId` for the responsible team member. Tasks support comments for collaboration -- use `createComment` with a `taskId` and `content` string. Returns the created task or comment with generated UUID and timestamps. Throws `NotFoundException` if the referenced project or assignee does not exist.

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

Allocate a team member to a project by specifying the `projectId`, `userId`, `hoursPerWeek`, and a `startDate`. This tracks resource capacity and prevents over-allocation across projects. Returns the created allocation with its UUID. Throws `ConflictException` if the user is already allocated to the same project for the same period.

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

Generate project reports by passing filter parameters. The `getProjectSummary` method accepts a `projectId` and returns task completion rates, budget usage, and milestone progress. The `getResourceUtilization` method accepts a `startDate` and returns allocation percentages across all team members. Both return structured report data as a Map.

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
