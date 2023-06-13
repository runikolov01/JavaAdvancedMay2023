package Exams.Exam18April2018.sanctuary;

import Exams.Exam18April2018.sanctuary.Elephant;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private List<Elephant> data;
    private int capacity;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (this.data.size() < this.capacity) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        for (Elephant el : data) {
            if (el.getName().equals(name)) {
                return data.remove(el);
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant el : data) {
            if (el.getRetiredFrom().equals(retiredFrom)) {
                return el;
            }
        }
        return null;
    }

    public Elephant getOldestElephant() {
        int age = 0;
        Elephant elep = null;
        for (Elephant el : data) {
            if (el.getAge() > age) {
                age = el.getAge();
            }
        }

        for (Elephant el : data) {
            if (el.getAge() == age) {
                elep = el;
            }
        }
        return elep;
    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:").append(System.lineSeparator());
        for (Elephant el : data) {
            sb.append(String.format("%s came from: %s", el.getName(), el.getRetiredFrom())).append(System.lineSeparator());
        }
        return sb.toString();
    }

}
