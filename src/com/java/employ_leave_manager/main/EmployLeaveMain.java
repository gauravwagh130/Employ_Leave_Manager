package com.java.employ_leave_manager.main;

import com.java.employ_leave_manager.bal.EmployLeaveBal;
import com.java.employ_leave_manager.exceptions.EmployLeaveException;
import com.java.employ_leave_manager.model.EmployLeave;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployLeaveMain {
    static EmployLeaveBal employLeaveBal;

    static {
        employLeaveBal = new EmployLeaveBal();
    }

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");

    public static void addEmployLeaveMain() throws EmployLeaveException {
        Scanner sc = new Scanner(System.in);
        EmployLeave leave = new EmployLeave();

        try {
            System.out.println("Enter Leave Id:");
            leave.setLeaveId(sc.nextInt());

            System.out.println("Enter Employee Id:");
            leave.setEmpId(sc.nextInt());
            sc.nextLine();

            System.out.println("Enter Leave Start Date (dd-MM-yyyy):");
            String start = sc.nextLine();
            Date startDate = SDF.parse(start);
            leave.setLeaveStartDate(startDate);

            System.out.println("Enter Leave End Date (dd-MM-yyyy):");
            String end = sc.nextLine();
            Date endDate = SDF.parse(end);
            leave.setLeaveEndDate(endDate);

            System.out.println("Enter Leave Reason:");
            leave.setLeaveReason(sc.nextLine());

            System.out.println(employLeaveBal.addEmployLeaveBal(leave));

        } catch (ParseException pe) {
            throw new EmployLeaveException("Invalid date format. Use dd-MM-yyyy.");
        }
    }

    public static void showAllLeavesMain() {
        List<EmployLeave> list = employLeaveBal.getAllEmployLeave();
        list.forEach(x -> System.out.println(x));
    }


    public static void searchLeaveMain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Leave Id:");
        int id = sc.nextInt();
        EmployLeave leave = employLeaveBal.searchEmployLeaveBal(id);
        if (leave != null) {
            System.out.println(leave);
        } else {
            System.out.println("Leave not found for id: " + id);
        }
    }

    public static void deleteLeaveMain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Leave Id:");
        int id = sc.nextInt();
        System.out.println(employLeaveBal.deleteEmployLeaveBal(id));
    }

    public static void updateLeaveMain() throws EmployLeaveException {
        Scanner sc = new Scanner(System.in);
        EmployLeave leave = new EmployLeave();

        try {
            System.out.println("Enter Leave Id to update:");
            leave.setLeaveId(sc.nextInt());

            System.out.println("Enter Employee Id:");
            leave.setEmpId(sc.nextInt());
            sc.nextLine();

            System.out.println("Enter Leave Start Date (dd-MM-yyyy):");
            String start = sc.nextLine();
            leave.setLeaveStartDate(SDF.parse(start));

            System.out.println("Enter Leave End Date (dd-MM-yyyy):");
            String end = sc.nextLine();
            leave.setLeaveEndDate(SDF.parse(end));

            System.out.println("Enter Leave Reason:");
            leave.setLeaveReason(sc.nextLine());

            System.out.println(employLeaveBal.updateEmployLeaveBal(leave));

        } catch (ParseException pe) {
            throw new EmployLeaveException("Invalid date format. Use dd-MM-yyyy.");
        }
    }

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("O P T I O N S");
            System.out.println("1. Add Leave");
            System.out.println("2. Show All Leaves");
            System.out.println("3. Search Leave");
            System.out.println("4. Delete Leave");
            System.out.println("5. Update Leave");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        addEmployLeaveMain();
                    } catch (EmployLeaveException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    showAllLeavesMain();
                    break;
                case 3:
                    searchLeaveMain();
                    break;
                case 4:
                    deleteLeaveMain();
                    break;
                case 5:
                    try {
                        updateLeaveMain();
                    } catch (EmployLeaveException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);
    }
}
