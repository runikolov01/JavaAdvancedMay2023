package Exams.Exam15Dec2021.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        if (!fishInPool.contains(fish) && fishInPool.size() < capacity) {
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                return fishInPool.remove(fish);
            }
        }
        return false;
    }

    public Fish findFish(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d", name, size)).append(System.lineSeparator());
        for (Fish fish : fishInPool) {
            sb.append(fish).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
