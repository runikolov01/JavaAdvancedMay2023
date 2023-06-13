package Exams.Exam18Aug2021.cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() < this.capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee empl : employees) {
            if (empl.getName().equals(name)) {
                return employees.remove(empl);
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s:", name)).append(System.lineSeparator());
        employees.forEach(empl -> sb.append(empl).append("\n"));
        return sb.toString();
    }
}
