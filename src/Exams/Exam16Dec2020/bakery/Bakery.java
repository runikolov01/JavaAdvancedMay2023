package Exams.Exam16Dec2020.bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < this.capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
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
        for (Employee empl : employees) {
            if (empl.getName().equals(name)) {
                return empl;
            }
        }
        return null;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:", name)).append(System.lineSeparator());
        employees.forEach(e -> sb.append(e).append(System.lineSeparator()));
        return sb.toString();
    }
}
