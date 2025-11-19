package com.java.employ_leave_manager.model;

import java.util.Date;

public class EmployLeave {
    private int leaveId;
    private int empId;
    private Date leaveStartDate;
    private Date leaveEndDate;
    private int noOfDays;
    private Date appliedOn;
    private String leaveReason;

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Date getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(Date leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public Date getLeaveEndDate() {
        return leaveEndDate;
    }

    public void setLeaveEndDate(Date leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public Date getAppliedOn() {
        return appliedOn;
    }

    public void setAppliedOn(Date appliedOn) {
        this.appliedOn = appliedOn;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public EmployLeave(){};

    public EmployLeave(int leaveId, int empId, Date leaveStartDate, Date leaveEndDate, Date appliedOn, String leaveReason, int noOfDays) {
        this.leaveId = leaveId;
        this.empId = empId;
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
        this.appliedOn = appliedOn;
        this.leaveReason = leaveReason;
        this.noOfDays = noOfDays;
    }

    @Override
    public String toString() {
        return "EmployLeave{" +
                "leaveId=" + leaveId +
                ", empId=" + empId +
                ", leaveStartDate=" + leaveStartDate +
                ", leaveEndDate=" + leaveEndDate +
                ", noOfDays=" + noOfDays +
                ", appliedOn=" + appliedOn +
                ", leaveReason='" + leaveReason + '\'' +
                '}';
    }
}
