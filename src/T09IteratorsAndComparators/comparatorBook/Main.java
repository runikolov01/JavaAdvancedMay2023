package T09IteratorsAndComparators.comparatorBook;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Case", 1930, "Dorothy Sayers", "Robert Eustace");

        BookComparator bc = new BookComparator();
        bc.compare(bookOne, bookTwo);
    }
}