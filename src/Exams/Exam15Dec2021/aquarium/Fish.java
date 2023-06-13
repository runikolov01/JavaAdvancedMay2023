package Exams.Exam15Dec2021.aquarium;

public class Fish {
    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFins() {
        return fins;
    }

    public void setFins(int fins) {
        this.fins = fins;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Fish: %s", name)).append(System.lineSeparator());
        sb.append(String.format("Color: %s", color)).append(System.lineSeparator());
        sb.append(String.format("Number of fins: %d", fins)).append(System.lineSeparator());
        return sb.toString();
    }
}
