package com.essabu.hr;

import com.essabu.common.internal.HttpClientWrapper;

/**
 * Client for the HR service module.
 * Provides access to all HR-related API resources through lazy-initialized sub-APIs.
 */
public final class HrClient {

    private final HttpClientWrapper http;

    private volatile EmployeeApi employeeApi;
    private volatile ContractApi contractApi;
    private volatile LeaveApi leaveApi;
    private volatile PayrollApi payrollApi;
    private volatile ShiftApi shiftApi;
    private volatile DepartmentApi departmentApi;
    private volatile PositionApi positionApi;
    private volatile AttendanceApi attendanceApi;
    private volatile DocumentApi documentApi;
    private volatile TrainingApi trainingApi;
    private volatile SkillApi skillApi;
    private volatile RecruitmentApi recruitmentApi;
    private volatile PerformanceApi performanceApi;
    private volatile OnboardingApi onboardingApi;
    private volatile TimesheetApi timesheetApi;
    private volatile BenefitApi benefitApi;
    private volatile DisciplinaryApi disciplinaryApi;
    private volatile LoanApi loanApi;
    private volatile ExpenseReportApi expenseReportApi;
    private volatile ConfigApi configApi;

    public HrClient(HttpClientWrapper http) {
        this.http = http;
    }

    public EmployeeApi employees() {
        if (employeeApi == null) { synchronized (this) { if (employeeApi == null) employeeApi = new EmployeeApi(http); } }
        return employeeApi;
    }

    public ContractApi contracts() {
        if (contractApi == null) { synchronized (this) { if (contractApi == null) contractApi = new ContractApi(http); } }
        return contractApi;
    }

    public LeaveApi leaves() {
        if (leaveApi == null) { synchronized (this) { if (leaveApi == null) leaveApi = new LeaveApi(http); } }
        return leaveApi;
    }

    public PayrollApi payroll() {
        if (payrollApi == null) { synchronized (this) { if (payrollApi == null) payrollApi = new PayrollApi(http); } }
        return payrollApi;
    }

    public ShiftApi shifts() {
        if (shiftApi == null) { synchronized (this) { if (shiftApi == null) shiftApi = new ShiftApi(http); } }
        return shiftApi;
    }

    public DepartmentApi departments() {
        if (departmentApi == null) { synchronized (this) { if (departmentApi == null) departmentApi = new DepartmentApi(http); } }
        return departmentApi;
    }

    public PositionApi positions() {
        if (positionApi == null) { synchronized (this) { if (positionApi == null) positionApi = new PositionApi(http); } }
        return positionApi;
    }

    public AttendanceApi attendances() {
        if (attendanceApi == null) { synchronized (this) { if (attendanceApi == null) attendanceApi = new AttendanceApi(http); } }
        return attendanceApi;
    }

    public DocumentApi documents() {
        if (documentApi == null) { synchronized (this) { if (documentApi == null) documentApi = new DocumentApi(http); } }
        return documentApi;
    }

    public TrainingApi trainings() {
        if (trainingApi == null) { synchronized (this) { if (trainingApi == null) trainingApi = new TrainingApi(http); } }
        return trainingApi;
    }

    public SkillApi skills() {
        if (skillApi == null) { synchronized (this) { if (skillApi == null) skillApi = new SkillApi(http); } }
        return skillApi;
    }

    public RecruitmentApi recruitment() {
        if (recruitmentApi == null) { synchronized (this) { if (recruitmentApi == null) recruitmentApi = new RecruitmentApi(http); } }
        return recruitmentApi;
    }

    public PerformanceApi performance() {
        if (performanceApi == null) { synchronized (this) { if (performanceApi == null) performanceApi = new PerformanceApi(http); } }
        return performanceApi;
    }

    public OnboardingApi onboarding() {
        if (onboardingApi == null) { synchronized (this) { if (onboardingApi == null) onboardingApi = new OnboardingApi(http); } }
        return onboardingApi;
    }

    public TimesheetApi timesheets() {
        if (timesheetApi == null) { synchronized (this) { if (timesheetApi == null) timesheetApi = new TimesheetApi(http); } }
        return timesheetApi;
    }

    public BenefitApi benefits() {
        if (benefitApi == null) { synchronized (this) { if (benefitApi == null) benefitApi = new BenefitApi(http); } }
        return benefitApi;
    }

    public DisciplinaryApi disciplinary() {
        if (disciplinaryApi == null) { synchronized (this) { if (disciplinaryApi == null) disciplinaryApi = new DisciplinaryApi(http); } }
        return disciplinaryApi;
    }

    public LoanApi loans() {
        if (loanApi == null) { synchronized (this) { if (loanApi == null) loanApi = new LoanApi(http); } }
        return loanApi;
    }

    public ExpenseReportApi expenseReports() {
        if (expenseReportApi == null) { synchronized (this) { if (expenseReportApi == null) expenseReportApi = new ExpenseReportApi(http); } }
        return expenseReportApi;
    }

    public ConfigApi config() {
        if (configApi == null) { synchronized (this) { if (configApi == null) configApi = new ConfigApi(http); } }
        return configApi;
    }
}
