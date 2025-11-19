package com.java.employ_leave_manager.bal;

import com.java.employ_leave_manager.dao.EmployLeaveDao;
import com.java.employ_leave_manager.dao.EmployLeaveDaoImp;
import com.java.employ_leave_manager.exceptions.EmployLeaveException;
import com.java.employ_leave_manager.model.EmployLeave;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class EmployLeaveBal {
    static StringBuilder sb = new StringBuilder();
    static EmployLeaveDao employLeaveDao = new EmployLeaveDaoImp();
    static ZoneId ZONE = ZoneId.systemDefault();

    public List<EmployLeave> getAllEmployLeave(){
        return employLeaveDao.getAllEmployLeaveDao();
    }

    public String addEmployLeaveBal(EmployLeave employLeave) throws EmployLeaveException {
        if (validateLeave(employLeave) == true) {
            employLeave.setAppliedOn(toDate(LocalDate.now()));
            employLeave.setNoOfDays(calculateNoOfDays(employLeave.getLeaveStartDate(), employLeave.getLeaveEndDate()));
            return employLeaveDao.addEmployLeaveDao(employLeave);
        }
        throw new EmployLeaveException(sb.toString());
    }

    public String updateEmployLeaveBal(EmployLeave employLeave) throws EmployLeaveException {
        if (validateLeave(employLeave)) {
            employLeave.setAppliedOn(toDate(LocalDate.now()));
            employLeave.setNoOfDays(calculateNoOfDays(employLeave.getLeaveStartDate(), employLeave.getLeaveEndDate()));
            return employLeaveDao.updateEmployleaveDao(employLeave);
        }
        throw new EmployLeaveException(sb.toString());
    }

    public String deleteEmployLeaveBal(int leaveId) {
        return employLeaveDao.deleteEmployLeaveDao(leaveId);
    }

    public EmployLeave searchEmployLeaveBal(int leaveId) {
        return employLeaveDao.searchEmployLeaveDao(leaveId);
    }


    public boolean validateLeave(EmployLeave employLeave) {
        boolean isValid = true;
        
        if (employLeave == null) {
            sb.append("EmployLeave cannot be null.");
           isValid = false;
        }

        Date startDate = employLeave.getLeaveStartDate();
        Date endDate = employLeave.getLeaveEndDate();

        LocalDate start = toLocalDate(startDate);
        LocalDate end = toLocalDate(endDate);
        LocalDate today = LocalDate.now(ZONE);
        LocalDate yesterday = today.minusDays(1);


        if (start.isEqual(yesterday)) {
            sb.append("LeaveStartDate cannot be yesterday. ");
            isValid = false;
        }


        if (end.isEqual(yesterday)) {
            sb.append("LeaveEndDate cannot be yesterday. ");
            isValid=false;
        }

        if (start.isAfter(end)) {
            sb.append("LeaveStartDate cannot be after LeaveEndDate. ");
            isValid = false;
        }

        return isValid;
    }


    private LocalDate toLocalDate(Date d) {
        if (d == null) return null;
        return d.toInstant().atZone(ZONE).toLocalDate();
    }

    private Date toDate(LocalDate ld) {
        if (ld == null) return null;
        return Date.from(ld.atStartOfDay(ZONE).toInstant());
    }

    private int calculateNoOfDays(Date startDate, Date endDate) {
        LocalDate start = toLocalDate(startDate);
        LocalDate end = toLocalDate(endDate);
        long daysBetween = ChronoUnit.DAYS.between(start, end) + 1;
        return (int) daysBetween;
    }
}
