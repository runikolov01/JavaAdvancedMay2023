package Exams.Exam22Oct2022.shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (this.data.size() < this.capacity) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal an : data) {
            if (an.getName().equals(name)) {
                return this.data.remove(an);
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        for (Animal an : data) {
            if (an.getName().equals(name) && an.getCaretaker().equals(caretaker)) {
                return an;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        int age = 0;
        Animal anim = null;
        for (Animal an : data) {
            int curAge = an.getAge();
            if (curAge > age) {
                age = curAge;
            }
        }
        for (Animal an : data) {
            if (an.getAge() == age) {
                anim = an;
            }
        }
        return anim;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The shelter has the following animals:")).append(System.lineSeparator());
        for (Animal an : data) {
            sb.append(String.format("%s %s", an.getName(), an.getCaretaker())).append(System.lineSeparator());
        }
        return sb.toString();
    }

}
