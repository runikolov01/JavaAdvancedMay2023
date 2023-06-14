package Exams.Exam20Febr2021.dealership;

public class Main {
    public static void main(String[] args) {
// Initialize the repository
        Dealership dealership = new Dealership("Autofest", 5);
        System.out.println(dealership.getLatestCar());
    }
}
