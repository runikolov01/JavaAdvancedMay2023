package Exams.Exam14April2021.University;

import java.util.ArrayList;
import java.util.List;

public class University {
    public  List<Student> students;
    public  int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() < this.capacity) {
            if (!students.contains(student)) {
                students.add(student);
                return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            } else {
                return "Student is already in the university";
            }
        } else {
            return "No seats in the university";
        }
    }

    public String dismissStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return "Removed student " + student.getFirstName() + " " + student.getLastName();
        } else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student st : students) {
            if (st.getFirstName().equals(firstName) && st.getLastName().equals(lastName)) {
                return st;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student st : students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s", st.getFirstName(), st.getLastName(), st.getBestSubject())).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
