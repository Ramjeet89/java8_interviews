package com.java8.interviews.streamsapi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDataService {

    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(
                231,
                "Jiya ",
                "Brein",
                 LocalDate.of(1990, 8, 27),
                "Team Lead",
                "jiya@gmail.com",
                25,
                50001.0,
                 Gender.FEMALE, "IT",
                2014,
                "Bangalore",
                List.of("9108815727", "9798463412"),
                EmployeeType.FULLTIME,
                List.of("Java", "Spring boot")
        ));

        employees.add(new Employee(131, "Paul", " Niksui", LocalDate.of(1991, 5, 25),
                "Hardware Engineer", "paul@gmail.com", 26, 40001.0, Gender.MALE, "ADMIN",
                2019, "Hyderabad", List.of("9108815767", "9798463492"), EmployeeType.PARTTIME, List.of("Python", "ML")));

        employees.add(new Employee(221, "Martin", " Theron", LocalDate.of(1995, 4, 27),
                "Team Lead", "martin@gmail.com", 22, 80001.0, Gender.MALE, "HR",
                2013, "Delhi", List.of("8808815727", "9798463652"), EmployeeType.CONTRACT, List.of("DotNet", "SQL Server")));

        employees.add(new Employee(331, "Murali", "Gowda", LocalDate.of(1990, 2, 21),
                "Developer", "murali@gmail.com", 25, 53001.0, Gender.MALE, "Account",
                2020, "Bangalore", List.of("9108815727", "9798463412"), EmployeeType.FULLTIME, List.of("Java", "Spring boot")));

        employees.add(new Employee(831, "Nima", " Roy", LocalDate.of(1990, 8, 27),
                "Tester", "nima@gmail.com", 25, 44001.0, Gender.FEMALE, "IT",
                2023, "Bangalore", List.of("9108816627", "9700463412"), EmployeeType.PARTTIME, List.of("PHP", "HTML")));
        return employees;
    }
}