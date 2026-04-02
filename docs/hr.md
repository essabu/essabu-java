# HR Module Reference

The HR module provides comprehensive human resource management including employees, contracts, leave management, payroll, shifts, recruitment, performance reviews, and more.

## Client Access

```java
EssabuClient essabu = new EssabuClient("your-api-key");
HrClient hr = essabu.hr();
```

## Available API Classes

| Class | Accessor | Description |
|-------|----------|-------------|
| `EmployeeApi` | `hr.employees()` | Employee records and leave balances |
| `ContractApi` | `hr.contracts()` | Employment contracts |
| `LeaveApi` | `hr.leaves()` | Leave requests with approval workflow |
| `PayrollApi` | `hr.payroll()` | Payroll runs and payslips |
| `ShiftApi` | `hr.shifts()` | Shifts, schedules, and swap requests |
| `DepartmentApi` | `hr.departments()` | Organizational departments |
| `PositionApi` | `hr.positions()` | Job positions |
| `AttendanceApi` | `hr.attendances()` | Attendance tracking |
| `DocumentApi` | `hr.documents()` | Employee documents with download |
| `TrainingApi` | `hr.trainings()` | Training programs |
| `SkillApi` | `hr.skills()` | Skills and employee-skill assignments |
| `RecruitmentApi` | `hr.recruitment()` | Job postings, applications, interviews |
| `PerformanceApi` | `hr.performance()` | Reviews, review cycles, goals |
| `OnboardingApi` | `hr.onboarding()` | Onboarding checklists |
| `TimesheetApi` | `hr.timesheets()` | Timesheet entries |
| `BenefitApi` | `hr.benefits()` | Benefit plans and employee enrollment |
| `DisciplinaryApi` | `hr.disciplinary()` | Disciplinary actions |
| `LoanApi` | `hr.loans()` | Employee loans |
| `ExpenseReportApi` | `hr.expenseReports()` | Expense reports |
| `ConfigApi` | `hr.config()` | HR config, leave policies, holidays, approval workflows |

---

## EmployeeApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(UUID companyId, PageRequest) -> PageResponse<Map>` | `GET /api/hr/employees?companyId=` | List employees for a company |
| `getById(UUID id) -> Map` | `GET /api/hr/employees/{id}` | Get employee by ID |
| `create(Map request) -> Map` | `POST /api/hr/employees` | Create a new employee |
| `update(UUID id, Map request) -> Map` | `PUT /api/hr/employees/{id}` | Update an employee |
| `delete(UUID id) -> void` | `DELETE /api/hr/employees/{id}` | Delete an employee |
| `getLeaveBalance(UUID employeeId) -> Map` | `GET /api/hr/employees/{id}/leave-balance` | Get leave balance |

```java
// List employees
PageResponse<Map> employees = hr.employees().list(companyId, new PageRequest(1, 20));

// Create employee
Map<String, Object> req = Map.of("firstName", "John", "lastName", "Doe", "email", "john@example.com");
Map employee = hr.employees().create(req);
```

## ContractApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/hr/contracts` | List contracts |
| `getById(UUID id) -> Map` | `GET /api/hr/contracts/{id}` | Get contract by ID |
| `create(Map request) -> Map` | `POST /api/hr/contracts` | Create a contract |
| `update(UUID id, Map request) -> Map` | `PUT /api/hr/contracts/{id}` | Update a contract |
| `delete(UUID id) -> void` | `DELETE /api/hr/contracts/{id}` | Delete a contract |

## LeaveApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/hr/leave-requests` | List leave requests |
| `getById(UUID id) -> Map` | `GET /api/hr/leave-requests/{id}` | Get leave request |
| `create(Map request) -> Map` | `POST /api/hr/leave-requests` | Create a leave request |
| `update(UUID id, Map request) -> Map` | `PUT /api/hr/leave-requests/{id}` | Update a leave request |
| `delete(UUID id) -> void` | `DELETE /api/hr/leave-requests/{id}` | Delete a leave request |
| `approve(UUID id) -> Map` | `POST /api/hr/leave-requests/{id}/approve` | Approve a leave request |
| `reject(UUID id, Map request) -> Map` | `POST /api/hr/leave-requests/{id}/reject` | Reject a leave request |

```java
// Approve a leave request
Map approved = hr.leaves().approve(leaveRequestId);
```

## PayrollApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `listRuns(PageRequest) -> PageResponse<Map>` | `GET /api/hr/payroll-runs` | List payroll runs |
| `getRunById(UUID id) -> Map` | `GET /api/hr/payroll-runs/{id}` | Get payroll run |
| `createRun(Map request) -> Map` | `POST /api/hr/payroll-runs` | Create a payroll run |
| `approveRun(UUID id) -> Map` | `POST /api/hr/payroll-runs/{id}/approve` | Approve a payroll run |
| `listPayslips(UUID payrollRunId, PageRequest) -> PageResponse<Map>` | `GET /api/hr/payslips?payrollRunId=` | List payslips |
| `getPayslipById(UUID id) -> Map` | `GET /api/hr/payslips/{id}` | Get a payslip |
| `downloadPayslip(UUID id) -> byte[]` | `GET /api/hr/payslips/{id}/download` | Download payslip PDF |

```java
// Run payroll and download payslip
Map run = hr.payroll().createRun(Map.of("month", "2026-03", "departmentId", deptId));
hr.payroll().approveRun(runId);
byte[] pdf = hr.payroll().downloadPayslip(payslipId);
```

## ShiftApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/hr/shifts` | List shifts |
| `getById(UUID id) -> Map` | `GET /api/hr/shifts/{id}` | Get shift |
| `create(Map request) -> Map` | `POST /api/hr/shifts` | Create a shift |
| `update(UUID id, Map request) -> Map` | `PUT /api/hr/shifts/{id}` | Update a shift |
| `delete(UUID id) -> void` | `DELETE /api/hr/shifts/{id}` | Delete a shift |
| `listSchedules(PageRequest) -> PageResponse<Map>` | `GET /api/hr/shift-schedules` | List shift schedules |
| `getScheduleById(UUID id) -> Map` | `GET /api/hr/shift-schedules/{id}` | Get shift schedule |
| `createSchedule(Map request) -> Map` | `POST /api/hr/shift-schedules` | Create a shift schedule |
| `updateSchedule(UUID id, Map request) -> Map` | `PUT /api/hr/shift-schedules/{id}` | Update a shift schedule |
| `deleteSchedule(UUID id) -> void` | `DELETE /api/hr/shift-schedules/{id}` | Delete a shift schedule |
| `listSwapRequests(PageRequest) -> PageResponse<Map>` | `GET /api/hr/shift-swap-requests` | List swap requests |
| `createSwapRequest(Map request) -> Map` | `POST /api/hr/shift-swap-requests` | Create a swap request |
| `approveSwapRequest(UUID id) -> Map` | `POST /api/hr/shift-swap-requests/{id}/approve` | Approve swap |
| `rejectSwapRequest(UUID id) -> Map` | `POST /api/hr/shift-swap-requests/{id}/reject` | Reject swap |

## RecruitmentApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `listJobPostings(PageRequest) -> PageResponse<Map>` | `GET /api/hr/job-postings` | List job postings |
| `getJobPostingById(UUID) -> Map` | `GET /api/hr/job-postings/{id}` | Get job posting |
| `createJobPosting(Map) -> Map` | `POST /api/hr/job-postings` | Create job posting |
| `updateJobPosting(UUID, Map) -> Map` | `PUT /api/hr/job-postings/{id}` | Update job posting |
| `deleteJobPosting(UUID) -> void` | `DELETE /api/hr/job-postings/{id}` | Delete job posting |
| `listApplications(PageRequest) -> PageResponse<Map>` | `GET /api/hr/applications` | List applications |
| `getApplicationById(UUID) -> Map` | `GET /api/hr/applications/{id}` | Get application |
| `createApplication(Map) -> Map` | `POST /api/hr/applications` | Create application |
| `updateApplication(UUID, Map) -> Map` | `PUT /api/hr/applications/{id}` | Update application |
| `deleteApplication(UUID) -> void` | `DELETE /api/hr/applications/{id}` | Delete application |
| `listInterviews(PageRequest) -> PageResponse<Map>` | `GET /api/hr/interviews` | List interviews |
| `getInterviewById(UUID) -> Map` | `GET /api/hr/interviews/{id}` | Get interview |
| `createInterview(Map) -> Map` | `POST /api/hr/interviews` | Schedule interview |
| `updateInterview(UUID, Map) -> Map` | `PUT /api/hr/interviews/{id}` | Update interview |
| `deleteInterview(UUID) -> void` | `DELETE /api/hr/interviews/{id}` | Delete interview |

## PerformanceApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `listReviews(PageRequest) -> PageResponse<Map>` | `GET /api/hr/performance-reviews` | List reviews |
| `getReviewById(UUID) -> Map` | `GET /api/hr/performance-reviews/{id}` | Get review |
| `createReview(Map) -> Map` | `POST /api/hr/performance-reviews` | Create review |
| `updateReview(UUID, Map) -> Map` | `PUT /api/hr/performance-reviews/{id}` | Update review |
| `deleteReview(UUID) -> void` | `DELETE /api/hr/performance-reviews/{id}` | Delete review |
| `listCycles(PageRequest) -> PageResponse<Map>` | `GET /api/hr/review-cycles` | List review cycles |
| `getCycleById(UUID) -> Map` | `GET /api/hr/review-cycles/{id}` | Get review cycle |
| `createCycle(Map) -> Map` | `POST /api/hr/review-cycles` | Create review cycle |
| `updateCycle(UUID, Map) -> Map` | `PUT /api/hr/review-cycles/{id}` | Update review cycle |
| `deleteCycle(UUID) -> void` | `DELETE /api/hr/review-cycles/{id}` | Delete review cycle |
| `listGoals(PageRequest) -> PageResponse<Map>` | `GET /api/hr/goals` | List goals |
| `getGoalById(UUID) -> Map` | `GET /api/hr/goals/{id}` | Get goal |
| `createGoal(Map) -> Map` | `POST /api/hr/goals` | Create goal |
| `updateGoal(UUID, Map) -> Map` | `PUT /api/hr/goals/{id}` | Update goal |
| `deleteGoal(UUID) -> void` | `DELETE /api/hr/goals/{id}` | Delete goal |

## BenefitApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `listPlans(PageRequest) -> PageResponse<Map>` | `GET /api/hr/benefit-plans` | List benefit plans |
| `getPlanById(UUID) -> Map` | `GET /api/hr/benefit-plans/{id}` | Get benefit plan |
| `createPlan(Map) -> Map` | `POST /api/hr/benefit-plans` | Create benefit plan |
| `updatePlan(UUID, Map) -> Map` | `PUT /api/hr/benefit-plans/{id}` | Update benefit plan |
| `deletePlan(UUID) -> void` | `DELETE /api/hr/benefit-plans/{id}` | Delete benefit plan |
| `listEmployeeBenefits(PageRequest) -> PageResponse<Map>` | `GET /api/hr/employee-benefits` | List employee benefits |
| `getEmployeeBenefitById(UUID) -> Map` | `GET /api/hr/employee-benefits/{id}` | Get employee benefit |
| `enrollEmployee(Map) -> Map` | `POST /api/hr/employee-benefits` | Enroll employee |
| `updateEmployeeBenefit(UUID, Map) -> Map` | `PUT /api/hr/employee-benefits/{id}` | Update enrollment |
| `removeEmployeeBenefit(UUID) -> void` | `DELETE /api/hr/employee-benefits/{id}` | Remove enrollment |

## SkillApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/hr/skills` | List skills |
| `getById(UUID) -> Map` | `GET /api/hr/skills/{id}` | Get skill |
| `create(Map) -> Map` | `POST /api/hr/skills` | Create skill |
| `update(UUID, Map) -> Map` | `PUT /api/hr/skills/{id}` | Update skill |
| `delete(UUID) -> void` | `DELETE /api/hr/skills/{id}` | Delete skill |
| `listEmployeeSkills(PageRequest) -> PageResponse<Map>` | `GET /api/hr/employee-skills` | List employee skills |
| `assignSkill(Map) -> Map` | `POST /api/hr/employee-skills` | Assign skill to employee |
| `removeEmployeeSkill(UUID) -> void` | `DELETE /api/hr/employee-skills/{id}` | Remove skill assignment |

## ConfigApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `getConfig() -> Map` | `GET /api/hr/config` | Get HR configuration |
| `updateConfig(Map) -> Map` | `PUT /api/hr/config` | Update HR configuration |
| `listLeavePolicies(PageRequest) -> PageResponse<Map>` | `GET /api/hr/config/leave-policies` | List leave policies |
| `getLeavePolicyById(UUID) -> Map` | `GET /api/hr/config/leave-policies/{id}` | Get leave policy |
| `createLeavePolicy(Map) -> Map` | `POST /api/hr/config/leave-policies` | Create leave policy |
| `updateLeavePolicy(UUID, Map) -> Map` | `PUT /api/hr/config/leave-policies/{id}` | Update leave policy |
| `deleteLeavePolicy(UUID) -> void` | `DELETE /api/hr/config/leave-policies/{id}` | Delete leave policy |
| `listHolidays(PageRequest) -> PageResponse<Map>` | `GET /api/hr/config/holidays` | List public holidays |
| `getHolidayById(UUID) -> Map` | `GET /api/hr/config/holidays/{id}` | Get holiday |
| `createHoliday(Map) -> Map` | `POST /api/hr/config/holidays` | Create holiday |
| `updateHoliday(UUID, Map) -> Map` | `PUT /api/hr/config/holidays/{id}` | Update holiday |
| `deleteHoliday(UUID) -> void` | `DELETE /api/hr/config/holidays/{id}` | Delete holiday |
| `listApprovalWorkflows(PageRequest) -> PageResponse<Map>` | `GET /api/hr/config/approval-workflows` | List workflows |
| `getApprovalWorkflowById(UUID) -> Map` | `GET /api/hr/config/approval-workflows/{id}` | Get workflow |
| `createApprovalWorkflow(Map) -> Map` | `POST /api/hr/config/approval-workflows` | Create workflow |
| `updateApprovalWorkflow(UUID, Map) -> Map` | `PUT /api/hr/config/approval-workflows/{id}` | Update workflow |
| `deleteApprovalWorkflow(UUID) -> void` | `DELETE /api/hr/config/approval-workflows/{id}` | Delete workflow |

## Standard CRUD APIs

The following APIs all provide standard CRUD operations (`list`, `getById`, `create`, `update`, `delete`):

| Class | Endpoint Base |
|-------|--------------|
| `DepartmentApi` | `/api/hr/departments` |
| `PositionApi` | `/api/hr/positions` |
| `AttendanceApi` | `/api/hr/attendances` |
| `TrainingApi` | `/api/hr/trainings` |
| `OnboardingApi` | `/api/hr/onboarding-checklists` |
| `TimesheetApi` | `/api/hr/timesheets` |
| `DisciplinaryApi` | `/api/hr/disciplinary-actions` |
| `LoanApi` | `/api/hr/loans` |
| `ExpenseReportApi` | `/api/hr/expense-reports` |

`DocumentApi` additionally provides: `download(UUID id) -> byte[]` at `GET /api/hr/documents/{id}/download`.

## Error Scenarios

| HTTP Status | Cause |
|-------------|-------|
| `400` | Invalid request data (missing required fields, bad date format) |
| `401` | Missing or expired authentication token |
| `403` | Insufficient permissions for the operation |
| `404` | Resource not found (invalid UUID) |
| `409` | Conflict (e.g., overlapping leave dates, duplicate contract) |
| `422` | Business rule violation (e.g., leave balance exceeded) |
