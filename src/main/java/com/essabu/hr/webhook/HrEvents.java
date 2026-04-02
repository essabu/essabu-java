package com.essabu.hr.webhook;

/**
 * Constants class defining all supported HR webhook event type strings.
 *
 * Provides named string constants for every event type that can be emitted
 * by the Essabu HR API via webhooks. Use these constants instead of hard-coded
 * strings when checking event types in webhook listeners to avoid typos and
 * enable compile-time verification. The constants are organized by domain area
 * including employee lifecycle, contract management, leave processing, payroll
 * execution, shift scheduling, training management, and recruitment workflow.
 *
 * Event categories:
 * - Employee: created, updated, terminated
 * - Contract: created, expiring, terminated
 * - Leave: requested, approved, rejected
 * - Payroll: calculated, approved, paid
 * - Shift: published, swap requested
 * - Training: completed, expiring
 * - Recruitment: application received, hired
 *
 * This class cannot be instantiated as it only contains static final constants.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class HrEvents {

    // --- Employee ---
    public static final String EMPLOYEE_CREATED = "employee.created";
    public static final String EMPLOYEE_UPDATED = "employee.updated";
    public static final String EMPLOYEE_TERMINATED = "employee.terminated";

    // --- Contract ---
    public static final String CONTRACT_CREATED = "contract.created";
    public static final String CONTRACT_EXPIRING = "contract.expiring";
    public static final String CONTRACT_TERMINATED = "contract.terminated";

    // --- Leave ---
    public static final String LEAVE_REQUESTED = "leave.requested";
    public static final String LEAVE_APPROVED = "leave.approved";
    public static final String LEAVE_REJECTED = "leave.rejected";

    // --- Payroll ---
    public static final String PAYROLL_CALCULATED = "payroll.calculated";
    public static final String PAYROLL_APPROVED = "payroll.approved";
    public static final String PAYROLL_PAID = "payroll.paid";

    // --- Shift ---
    public static final String SHIFT_PUBLISHED = "shift.published";
    public static final String SHIFT_SWAP_REQUESTED = "shift.swap_requested";

    // --- Training ---
    public static final String TRAINING_COMPLETED = "training.completed";
    public static final String TRAINING_EXPIRING = "training.expiring";

    // --- Recruitment ---
    public static final String RECRUITMENT_APPLICATION_RECEIVED = "recruitment.application_received";
    public static final String RECRUITMENT_HIRED = "recruitment.hired";

    private HrEvents() {
        // Constants class — not instantiable
    }
}
