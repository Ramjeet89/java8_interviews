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
        getEmployeesSalary(employees);
        listDownDept(employees);
        seniorEmp(employees);
        thirdHighestSalaryWithHighestAge(employees);
        sortByName(employees);
        increment10percentSalary(employees);
        increment10percentSalaryUsingSet(employees);
        greaterThen5000After10PercentIncrement(employees);
        findFirstEmployeeGreaterThen5000After10PercentIncrement(employees);
        flatMapEmployee(employees);
        sortCircuitData(employees);
        sortingByEmployeeFirstNameAndLastName(employees);
        reduceEmployeeSalary(employees);
        maxSalaryOfEmployee(employees);
        countEmployee(employees);
        sortEmployeeBasedOnGender(employees);
        sortByAge(employees);
    }

    private static void sortByAge(List<Employee> listOfEmployee) {
        List<Employee> sortByAge = listOfEmployee.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .toList();
        sortByAge.forEach(employee -> System.out.println(employee.getAge()));
    }

    private static void sortEmployeeBasedOnGender(List<Employee> listOfEmployee) {
        List<Employee> sortedByGender = listOfEmployee.stream()
                .filter(employee -> employee.getGender() == Gender.MALE)
                .sorted(Comparator.comparing(Employee::getFirstName))
                .toList();
        sortedByGender.forEach(System.out::println);
    }

    private static void countEmployee(List<Employee> listOfEmployee) {
        // long count = listOfEmployee.stream().count();
        IntSummaryStatistics summary = listOfEmployee.stream()
                .mapToInt(Employee::getId)
                .summaryStatistics();
        // System.out.println("Count:: " + count);
        System.out.println(summary.getCount());
    }

    private static void maxSalaryOfEmployee(List<Employee> listOfEmployee) {
        Employee maxSalary = listOfEmployee.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoClassDefFoundError::new);
        System.out.println("Max Salary:: " + maxSalary);
    }

    private static void reduceEmployeeSalary(List<Employee> listOfEmployee) {
        Double totalSalary = listOfEmployee.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        System.out.println("Total Salary: " + totalSalary);
    }

    private static void sortingByEmployeeFirstNameAndLastName(List<Employee> listOfEmployee) {
        List<Employee> sortByFirstNameAndLastName = listOfEmployee.stream()
                .sorted(Comparator.comparing(Employee::getFirstName)
                        .thenComparing(Employee::getLastName))
                .toList();
        System.out.println("Sort By Employee FirstName and LastName: " + sortByFirstNameAndLastName);
    }

    //sort circuit operations
    private static void sortCircuitData(List<Employee> listOfEmployee) {
        List<Employee> sortCircuitData = listOfEmployee
                .stream()
                .skip(1)
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(sortCircuitData);
    }

    //flatMap example
    private static void flatMapEmployee(List<Employee> listOfEmployee) {
        String phones = listOfEmployee.stream()
                .map(Employee::getPhones)
                .flatMap(strings -> strings.stream()).collect(Collectors.joining(","));
        System.out.println(phones);
    }

    private static void findFirstEmployeeGreaterThen5000After10PercentIncrement(List<Employee> listOfEmployee) {
        Employee greaterThen5000 = listOfEmployee.stream()
                .filter(emp -> emp.getSalary() > 5000)
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getDateOfBirth(),
                        emp.getJobTitle(),
                        emp.getEmail(),
                        emp.getAge(),
                        emp.getSalary() * 1.10,
                        emp.getGender(),
                        emp.getDepartment(),
                        emp.getYearOfJoining(),
                        emp.getLocation(),
                        emp.getPhones(),
                        emp.getEmployeeType(),
                        emp.getTraining()))
                .findFirst()
                .orElse(null);
        System.out.println("First Employee Greater Then 5000 After 10 % Increment: " + greaterThen5000);
    }

    private static void greaterThen5000After10PercentIncrement(List<Employee> listOfEmployee) {
        List<Employee> greaterThen5000 = listOfEmployee.stream()
                .filter(emp -> emp.getSalary() > 5000)
                .map(emp -> new Employee(
                                emp.getId(),
                                emp.getFirstName(),
                                emp.getLastName(),
                                emp.getDateOfBirth(),
                                emp.getJobTitle(),
                                emp.getEmail(),
                                emp.getAge(),
                                emp.getSalary() * 1.10,
                                emp.getGender(),
                                emp.getDepartment(),
                                emp.getYearOfJoining(),
                                emp.getLocation(),
                                emp.getPhones(),
                                emp.getEmployeeType(),
                                emp.getTraining()
                        )
                ).toList();
        System.out.println("Greater Then 5000 After 10 % Increment: " + greaterThen5000);
    }

    private static void increment10percentSalaryUsingSet(List<Employee> listOfEmployee) {
        Set<Employee> employees = listOfEmployee.stream()
                .map(emp -> new Employee(
                                emp.getId(),
                                emp.getFirstName(),
                                emp.getLastName(),
                                emp.getDateOfBirth(),
                                emp.getJobTitle(),
                                emp.getEmail(),
                                emp.getAge(),
                                emp.getSalary() * 1.10,
                                emp.getGender(),
                                emp.getDepartment(),
                                emp.getYearOfJoining(),
                                emp.getLocation(),
                                emp.getPhones(),
                                emp.getEmployeeType(),
                                emp.getTraining()
                        )
                ).collect(Collectors.toSet());
        System.out.println("After increment of 10% Using Set:  " + employees);
    }

    private static void increment10percentSalary(List<Employee> listOfEmployee) {
        List<Employee> employees = listOfEmployee.stream().map(emp -> new Employee(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getDateOfBirth(),
                        emp.getJobTitle(),
                        emp.getEmail(),
                        emp.getAge(),
                        emp.getSalary() * 1.10,
                        emp.getGender(),
                        emp.getDepartment(),
                        emp.getYearOfJoining(),
                        emp.getLocation(),
                        emp.getPhones(),
                        emp.getEmployeeType(),
                        emp.getTraining()
                )
        ).toList();
        System.out.println("After Increment 10%:  " + employees);
    }

    //sort the employee based on their firstname from the employee list
    private static void sortByName(List<Employee> listOfEmployee) {
        List<Employee> sortByName = listOfEmployee.stream()
                .sorted(Comparator.comparing(Employee::getFirstName)).toList();
        // Display sorted employees' first names
        System.out.println("Employees' first names sorted by first name:");
        sortByName.forEach(employee -> System.out.println(employee.getFirstName()));

    }


    //find the third-highest salary with the highest age in the organization
    private static void thirdHighestSalaryWithHighestAge(List<Employee> listOfEmployee) {
        Optional<Employee> thirdHighestSalaryWithHighestAge = listOfEmployee.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()
                        .thenComparing(Employee::getAge).reversed()).skip(2).findFirst();
        if (thirdHighestSalaryWithHighestAge.isPresent()) {
            Employee employee = thirdHighestSalaryWithHighestAge.get();
            System.out.println("Name: " + employee.getFirstName() + "" + employee.getLastName());
            System.out.println("Age: " + employee.getAge());
            System.out.println("Salary: " + employee.getSalary());
        } else {
            System.out.println("No employee found.");
        }
    }

    //Find out the height of experienced employees in the organization
    private static void seniorEmp(List<Employee> listOfEmployee) {
        Optional<Employee> seniorEmp = listOfEmployee.stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining))
                .findFirst();
        Employee seniorMostEmployee = seniorEmp.get();
        System.out.println("Most SeniorEmployee Details :");
        System.out.println("----------------------------");
        System.out.println("ID : " + seniorMostEmployee.getId());
        System.out.println("Name : " + seniorMostEmployee.getFirstName() + "" + seniorMostEmployee.getLastName());
        System.out.println("DOJ : " + seniorMostEmployee.getYearOfJoining());
    }

    //List Down the employee of Each Department.
    private static void listDownDept(List<Employee> listOfEmployee) {
        Map<String, List<Employee>> empList = listOfEmployee.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        Set<Map.Entry<String, List<Employee>>> entrySet = empList.entrySet();
        for (Map.Entry<String, List<Employee>> entry : entrySet) {
            System.out.println(" ");
            System.out.print("Employees In " + entry.getKey() + " :- ");
            System.out.print(" ");
            List<Employee> list = entry.getValue();
            for (Employee e : list) {
                System.out.println(e.getFirstName() + "" + e.getLastName());
            }
        }
    }

    //List down the employees of each department.
    private static void getEmployeesSalary(List<Employee> employees) {
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        // Print employees in each department
        employeesByDepartment.forEach((department, employeeList) -> {
            System.out.println("Department: " + department);
            employeeList.forEach(employee -> System.out.println("- " + employee.getFirstName()));
        });
    }

    //find the max salary based on the departments
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
        List<Map.Entry<Employee, Double>> sortedList = salaryMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .toList();
        // Create a list of sorted employees
        List<Employee> sortedEmployee = sortedList
                .stream()
                .map(Map.Entry::getKey)
                .toList();
        sortedEmployee.forEach(System.out::println);
    }

    //List down the salary of each employee.
    private static void getListDownTheSalaryOfEachEmployee(List<Employee> employees) {
        DoubleSummaryStatistics summaryStatistics = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
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
        Map<String, Long> numberOfEmpEachDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        numberOfEmpEachDept.forEach(
                (dept, count) -> System.out.println(dept + ":" + count));
    }

    //Get the Names of employees who joined after 2014.
    private static void getNameOfEmp(List<Employee> employees) {
        System.out.println("Name of the employees who joined before 2014: ");
        employees.stream()
                .filter(employee -> employee.getYearOfJoining() < 2014)
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    //Find the average age of Male and Female Employees.
    private static void findGender(List<Employee> employees) {
        Map<Gender, Double> avgAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println("Average Ages of MALE and FEMALE Employees:" + avgAge);
    }

    //Write a program to print the names of all departments in the organization
    private static void getDepartmentName(List<Employee> employees) {
        System.out.println("Name of all the Departments in the Organization: ");
        employees.stream().map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);
    }

    //find the number of counts of MALE and FEMALE employees in the organization
    private static void getCountOfMaleFemale(List<Employee> employees) {
        Map<Gender, Long> noOfMaleAndFemaleEmployees = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Total Number of MALE and FEMALE employees: " + noOfMaleAndFemaleEmployees);
    }


}
