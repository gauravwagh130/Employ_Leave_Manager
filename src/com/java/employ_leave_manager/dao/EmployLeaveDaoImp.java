package com.java.employ_leave_manager.dao;

import com.java.employ_leave_manager.model.EmployLeave;

import java.util.ArrayList;
import java.util.List;

public class EmployLeaveDaoImp implements EmployLeaveDao {
    static List<EmployLeave> employLeaveList;
    static {
        employLeaveList = new ArrayList<>();
    }

    @Override
    public List<EmployLeave> getAllEmployLeaveDao() {
        return employLeaveList;
    }

    @Override
    public String addEmployLeaveDao(EmployLeave employLeave) {
        employLeaveList.add(employLeave);
        return "Employ Leave Added";
    }

    @Override
    public String updateEmployleaveDao(EmployLeave employLeaveUpdate) {
        EmployLeave employLeaveFound = searchEmployLeaveDao(employLeaveUpdate.getLeaveId());
        if (employLeaveFound != null){
            employLeaveFound.setLeaveStartDate(employLeaveUpdate.getLeaveStartDate());
            employLeaveFound.setLeaveEndDate(employLeaveUpdate.getLeaveEndDate());
            employLeaveFound.setLeaveReason(employLeaveUpdate.getLeaveReason());
            employLeaveFound.setAppliedOn(employLeaveUpdate.getAppliedOn());
            employLeaveFound.setNoOfDays(employLeaveUpdate.getNoOfDays());
            return "Leave record Updated Successfully... ";

        }
        return "Leave Record not found...";
    }

    @Override
    public String deleteEmployLeaveDao(int leaveId) {
        EmployLeave employLeaveFound =searchEmployLeaveDao(leaveId);
        if (employLeaveFound != null){
            employLeaveList.remove(employLeaveFound);
            return "Leave Record deleted";
        }
        return "Record not found";
    }

    @Override
    public EmployLeave searchEmployLeaveDao(int leaveId) {
        EmployLeave employLeaveFound = employLeaveList.stream().filter(employLeave -> employLeave.getLeaveId() == leaveId).findFirst().orElse(null);
        return employLeaveFound;
    }
}
