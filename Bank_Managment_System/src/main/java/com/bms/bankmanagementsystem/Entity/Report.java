package com.bms.bankmanagementsystem.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId; // Auto-generated primary key

    private String reportType; // Type of report, e.g., "Transaction Report"
    private Date reportDate; // Date when the report is generated
    private String reportDetails; // Details or description of the report

    // New mapping to link to the BankTransaction entity
    @ManyToOne
    @JoinColumn(name = "transaction_id", nullable = false) // Ensure this column exists in your database schema
    private BankTransaction transaction;

    // Optional: If reports are generated by an employee, add this mapping
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false) // Foreign key to Employee entity
    private Employee employee;

    // Default Constructor
    public Report() {
        super();
    }

    // Parameterized Constructor
    public Report(Long reportId, String reportType, Date reportDate, String reportDetails,
                  BankTransaction transaction, Employee employee) {
        this.reportId = reportId;
        this.reportType = reportType;
        this.reportDate = reportDate;
        this.reportDetails = reportDetails;
        this.transaction = transaction;
        this.employee = employee;
    }

    // Getters and Setters
    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }

    public BankTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(BankTransaction transaction) {
        this.transaction = transaction;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // toString Method
    @Override
    public String toString() {
        return "Report [reportId=" + reportId + ", reportType=" + reportType + ", reportDate=" + reportDate
                + ", reportDetails=" + reportDetails + ", transaction=" + transaction + ", employee=" + employee + "]";
    }
}
