package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot par : data) {
            if (par.getName().equals(name)) {
                return data.remove(par);
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        return data.stream().filter(par -> par.getName().equals(name)).findFirst().orElse(null);

    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> matchedList = new ArrayList<>();
        for (Parrot parrot : data) {
            if (parrot.getSpecies().equals(species)) {
                matchedList.add(parrot);
            }
        }
        return matchedList;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Parrots available at %s:", name)).append(System.lineSeparator());
        for (Parrot par : data) {
            sb.append(par).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
