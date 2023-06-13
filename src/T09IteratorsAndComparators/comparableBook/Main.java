package T09IteratorsAndComparators.comparableBook;

public class Main {
    public static void main(String[] args) {
        Book first = new Book("Clean Code", 2000, "Uncle Bob");
        Book second = new Book("Thinking in Java", 2006, "Bruce Eckel");

        System.out.println(first.compareTo(second));
    }
}
