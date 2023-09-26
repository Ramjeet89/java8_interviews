package com.java8.interviews.streamsapi;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeMainTest {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeDataService.getEmployees();
        getCountOfMaleFemale(employees);
        getDepartmentName(employees);
        findGender(employees);
        getNameOfEmp(employees);
        countByDept(employees);
        avgSalary(employees);
        oldestEmp(employees);
        getListDownTheSalaryOfEachEmployee(employees);
        convertEmployeeOnMap(employees);
        findMaxSalaryBasedOnDepartment(employees);
    }

    private static void findMaxSalaryBasedOnDepartment(List<Employee> employees) {
        Map<String, Double> maxSalariesByDesignation = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                maxSalaryOpt -> maxSalaryOpt.map(Employee::getSalary).orElse(0.0))));
        maxSalariesByDesignation.forEach((dept, maxSalary) ->
                System.out.println("Department: " + dept + " - Max Salary: " + maxSalary));
    }

    private static void convertEmployeeOnMap(List<Employee> employees) {
        // Create a map for sorting based on salary (you can change the criteria)
        Map<Employee, Double> salaryMap = new HashMap<>();
        employees.forEach(emp -> salaryMap.put(emp, emp.getSalary()));
        // Sort the map by values (salary in this case) in ascending order
        List<Map.Entry<Employee, Double>> sortedList = salaryMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
        // Create a list of sorted employees
        List<Employee> sortedEmployee = sortedList.stream().map(Map.Entry::getKey).toList();
        sortedEmployee.forEach(System.out::println);
    }

    //List down the salary of each employee.
    private static void getListDownTheSalaryOfEachEmployee(List<Employee> employees) {
        DoubleSummaryStatistics summaryStatistics = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("List of Salary: " + summaryStatistics);
    }

    //Find out the oldest employee, his/her age and department?
    private static void oldestEmp(List<Employee> employees) {
        Optional<Employee> oldestEmployee = employees.stream().max(Comparator.comparingInt(Employee::getAge));
        Employee oldEmployee = oldestEmployee.get();
        System.out.println("Oldest Employee in the Org basis of Age and department: ");
        System.out.println("Name: " + oldEmployee.getFirstName() + " " + oldEmployee.getLastName());
        System.out.println("Age: " + oldEmployee.getAge());
        System.out.println("Department: " + oldEmployee.getDepartment());
    }

    //Find out the average salary of each department.
    private static void avgSalary(List<Employee> employees) {
        Map<String, Double> avgSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        avgSalary.forEach((key, value) -> System.out.println(key + "-" + value));
    }

    // Count the number of employees in each department.
    private static void countByDept(List<Employee> employees) {
        System.out.println("Count the number of employees in each departments: ");
        Map<String, Long> numberOfEmpEachDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        numberOfEmpEachDept.forEach((dept, count) -> System.out.println(dept + ":" + count));
    }

    //Get the Names of employees who joined after 2014.
    private static void getNameOfEmp(List<Employee> employees) {
        System.out.println("Name of the employees who joined before 2014: ");
        employees.stream().filter(employee -> employee.getYearOfJoining() < 2014).map(Employee::getFirstName).forEach(System.out::println);
    }

    //Find the average age of Male and Female Employees.
    private static void findGender(List<Employee> employees) {
        Map<Gender, Double> avgAge = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println("Average Ages of MALE and FEMALE Employees:" + avgAge);
    }

    //Write a program to print the names of all departments in the organization
    private static void getDepartmentName(List<Employee> employees) {
        System.out.println("Name of all the Departments in the Organization: ");
        employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
    }

    //find the number of counts of MALE and FEMALE employees in the organization
    private static void getCountOfMaleFemale(List<Employee> employees) {
        Map<Gender, Long> noOfMaleAndFemaleEmployees = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Total Number of MALE and FEMALE employees: " + noOfMaleAndFemaleEmployees);
    }


}
