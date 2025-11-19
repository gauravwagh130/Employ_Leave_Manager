package com.java.employ_leave_manager.dao;

import com.java.employ_leave_manager.model.EmployLeave;

import java.util.List;

public interface EmployLeaveDao {
List<EmployLeave> getAllEmployLeaveDao();
String addEmployLeaveDao(EmployLeave employLeave);
String updateEmployleaveDao(EmployLeave employLeaveUpdate);
String deleteEmployLeaveDao(int leaveId);
EmployLeave searchEmployLeaveDao(int leaveId);
}
