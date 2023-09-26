package com.java8.interviews.streamsapi;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String jobTitle;
    private String email;
    private int age;
    private double salary;
    private Gender gender;
    private String department;
    private int yearOfJoining;
    private String location;
    private List<String> phones;
    private EmployeeType employeeType;
    private List<String> training;

    public Employee() {

    }

    public Employee(int id, String firstName, String lastName, LocalDate dateOfBirth, String jobTitle, String email, int age, double salary, Gender gender, String department, int yearOfJoining, String location, List<String> phones, EmployeeType employeeType, List<String> training) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.jobTitle = jobTitle;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.location = location;
        this.phones = phones;
        this.employeeType = employeeType;
        this.training = training;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public List<String> getTraining() {
        return training;
    }

    public void setTraining(List<String> training) {
        this.training = training;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && Double.compare(employee.salary, salary) == 0
                && yearOfJoining == employee.yearOfJoining && Objects.equals(firstName, employee.firstName)
                && Objects.equals(lastName, employee.lastName) && Objects.equals(dateOfBirth, employee.dateOfBirth)
                && Objects.equals(jobTitle, employee.jobTitle) && Objects.equals(email, employee.email)
                && gender == employee.gender && Objects.equals(department, employee.department)
                && Objects.equals(location, employee.location) && Objects.equals(phones, employee.phones)
                && employeeType == employee.employeeType && Objects.equals(training, employee.training);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, dateOfBirth, jobTitle, email, age, salary, gender, department,
                yearOfJoining, location, phones, employeeType, training);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", jobTitle='" + jobTitle + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                ", department='" + department + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", location='" + location + '\'' +
                ", phones=" + phones +
                ", employeeType=" + employeeType +
                ", training=" + training +
                '}';
    }
}
