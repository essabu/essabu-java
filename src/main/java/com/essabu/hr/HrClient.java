package com.essabu.hr;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.hr.api.admin.ConfigApi;
import com.essabu.hr.api.admin.HistoryApi;
import com.essabu.hr.api.admin.ReportApi;
import com.essabu.hr.api.admin.WebhookApi;
import com.essabu.hr.api.compensation.BenefitApi;
import com.essabu.hr.api.compensation.ExpenseApi;
import com.essabu.hr.api.compensation.LoanApi;
import com.essabu.hr.api.compensation.PayrollApi;
import com.essabu.hr.api.core.DepartmentApi;
import com.essabu.hr.api.core.EmployeeApi;
import com.essabu.hr.api.core.PositionApi;
import com.essabu.hr.api.talent.DisciplinaryApi;
import com.essabu.hr.api.talent.DocumentApi;
import com.essabu.hr.api.talent.OnboardingApi;
import com.essabu.hr.api.talent.PerformanceApi;
import com.essabu.hr.api.talent.RecruitmentApi;
import com.essabu.hr.api.talent.SkillApi;
import com.essabu.hr.api.workforce.AttendanceApi;
import com.essabu.hr.api.workforce.ContractApi;
import com.essabu.hr.api.workforce.LeaveApi;
import com.essabu.hr.api.workforce.ShiftApi;
import com.essabu.hr.api.workforce.ShiftScheduleApi;
import com.essabu.hr.api.workforce.TimesheetApi;
import com.essabu.hr.api.workforce.TrainingApi;

/**
 * HR module client providing access to all HR API endpoints.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class HrClient {

    private final HttpClientWrapper http;

    private volatile EmployeeApi employeeApi;
    private volatile DepartmentApi departmentApi;
    private volatile PositionApi positionApi;
    private volatile ContractApi contractApi;
    private volatile AttendanceApi attendanceApi;
    private volatile LeaveApi leaveApi;
    private volatile ShiftApi shiftApi;
    private volatile ShiftScheduleApi shiftScheduleApi;
    private volatile TrainingApi trainingApi;
    private volatile PayrollApi payrollApi;
    private volatile ExpenseApi expenseApi;
    private volatile RecruitmentApi recruitmentApi;
    private volatile PerformanceApi performanceApi;
    private volatile OnboardingApi onboardingApi;
    private volatile DocumentApi documentApi;
    private volatile DisciplinaryApi disciplinaryApi;
    private volatile BenefitApi benefitApi;
    private volatile LoanApi loanApi;
    private volatile TimesheetApi timesheetApi;
    private volatile SkillApi skillApi;
    private volatile ReportApi reportApi;
    private volatile WebhookApi webhookApi;
    private volatile ConfigApi configApi;
    private volatile HistoryApi historyApi;

    public HrClient(HttpClientWrapper http) {
        this.http = http;
    }

    public EmployeeApi employees() { if (employeeApi == null) { synchronized (this) { if (employeeApi == null) { employeeApi = new EmployeeApi(http); } } } return employeeApi; }
    public DepartmentApi departments() { if (departmentApi == null) { synchronized (this) { if (departmentApi == null) { departmentApi = new DepartmentApi(http); } } } return departmentApi; }
    public PositionApi positions() { if (positionApi == null) { synchronized (this) { if (positionApi == null) { positionApi = new PositionApi(http); } } } return positionApi; }
    public ContractApi contracts() { if (contractApi == null) { synchronized (this) { if (contractApi == null) { contractApi = new ContractApi(http); } } } return contractApi; }
    public AttendanceApi attendances() { if (attendanceApi == null) { synchronized (this) { if (attendanceApi == null) { attendanceApi = new AttendanceApi(http); } } } return attendanceApi; }
    public LeaveApi leaves() { if (leaveApi == null) { synchronized (this) { if (leaveApi == null) { leaveApi = new LeaveApi(http); } } } return leaveApi; }
    public ShiftApi shifts() { if (shiftApi == null) { synchronized (this) { if (shiftApi == null) { shiftApi = new ShiftApi(http); } } } return shiftApi; }
    public ShiftScheduleApi shiftSchedules() { if (shiftScheduleApi == null) { synchronized (this) { if (shiftScheduleApi == null) { shiftScheduleApi = new ShiftScheduleApi(http); } } } return shiftScheduleApi; }
    public TrainingApi trainings() { if (trainingApi == null) { synchronized (this) { if (trainingApi == null) { trainingApi = new TrainingApi(http); } } } return trainingApi; }
    public PayrollApi payrolls() { if (payrollApi == null) { synchronized (this) { if (payrollApi == null) { payrollApi = new PayrollApi(http); } } } return payrollApi; }
    public ExpenseApi expenses() { if (expenseApi == null) { synchronized (this) { if (expenseApi == null) { expenseApi = new ExpenseApi(http); } } } return expenseApi; }
    public RecruitmentApi recruitment() { if (recruitmentApi == null) { synchronized (this) { if (recruitmentApi == null) { recruitmentApi = new RecruitmentApi(http); } } } return recruitmentApi; }
    public PerformanceApi performance() { if (performanceApi == null) { synchronized (this) { if (performanceApi == null) { performanceApi = new PerformanceApi(http); } } } return performanceApi; }
    public OnboardingApi onboarding() { if (onboardingApi == null) { synchronized (this) { if (onboardingApi == null) { onboardingApi = new OnboardingApi(http); } } } return onboardingApi; }
    public DocumentApi documents() { if (documentApi == null) { synchronized (this) { if (documentApi == null) { documentApi = new DocumentApi(http); } } } return documentApi; }
    public DisciplinaryApi disciplinary() { if (disciplinaryApi == null) { synchronized (this) { if (disciplinaryApi == null) { disciplinaryApi = new DisciplinaryApi(http); } } } return disciplinaryApi; }
    public BenefitApi benefits() { if (benefitApi == null) { synchronized (this) { if (benefitApi == null) { benefitApi = new BenefitApi(http); } } } return benefitApi; }
    public LoanApi loans() { if (loanApi == null) { synchronized (this) { if (loanApi == null) { loanApi = new LoanApi(http); } } } return loanApi; }
    public TimesheetApi timesheets() { if (timesheetApi == null) { synchronized (this) { if (timesheetApi == null) { timesheetApi = new TimesheetApi(http); } } } return timesheetApi; }
    public SkillApi skills() { if (skillApi == null) { synchronized (this) { if (skillApi == null) { skillApi = new SkillApi(http); } } } return skillApi; }
    public ReportApi reports() { if (reportApi == null) { synchronized (this) { if (reportApi == null) { reportApi = new ReportApi(http); } } } return reportApi; }
    public WebhookApi webhooks() { if (webhookApi == null) { synchronized (this) { if (webhookApi == null) { webhookApi = new WebhookApi(http); } } } return webhookApi; }
    public ConfigApi config() { if (configApi == null) { synchronized (this) { if (configApi == null) { configApi = new ConfigApi(http); } } } return configApi; }
    public HistoryApi history() { if (historyApi == null) { synchronized (this) { if (historyApi == null) { historyApi = new HistoryApi(http); } } } return historyApi; }
}
