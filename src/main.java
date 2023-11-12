import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library!");

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Display All Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();

                    Book newBook = new Book(title, year, author);
                    library.addItem(newBook);
                    break;

                case 2:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowItem(borrowTitle);
                    break;

                case 3:
                    library.displayAllItems();
                    break;

                case 0:
                    System.out.println("Exiting the Library. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 0);

        scanner.close();
    }
}