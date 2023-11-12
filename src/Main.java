import java.util.Scanner;

public class Main {

    private static int getValidNumberInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("=============================================");
                System.out.println("|Invalid input. Please enter a valid number.|");
                System.out.println("=============================================");
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n<================ Welcome to the Library! ================> ");

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Add DVD");
            System.out.println("4. Borrow DVD");
            System.out.println("5. Display All Books");
            System.out.println("6. Display All DVD");
            System.out.println("0. Exit");
            choice = getValidNumberInput(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    System.out.println("\n-----------------------------------");
                    System.out.print("| Enter book title       : ");
                    String title = scanner.nextLine();
                    int year = getValidNumberInput(scanner, "| Enter book year        : ");
                    System.out.print("| Enter book author      : ");
                    String author = scanner.nextLine();
                    int pages = getValidNumberInput(scanner, "| Enter book Pages       : ");
                    System.out.println("-----------------------------------");

                    Book newBook = new Book(title, year, author, pages);
                    library.addItem(newBook);
                    break;

                case 2:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowItem(borrowTitle);
                    break;

                case 3:
                    System.out.println("\n------------------------------------");
                    System.out.print("| Enter DVD title         : ");
                    String dvdTitle = scanner.nextLine();
                    int dvdYear = getValidNumberInput(scanner, "| Enter DVD year          : ");
                    System.out.print("| Enter DVD director      : ");
                    String dvdDirector = scanner.nextLine();
                    int dvdDur = getValidNumberInput(scanner, "| Enter DVD duration      : ");
                    System.out.println("------------------------------------");
                    DVD newDVD = new DVD(dvdTitle, dvdYear, dvdDirector, dvdDur);
                    library.addItem(newDVD);
                    break;

                case 4:
                    System.out.println("Enter DVD title to borrow : ");
                    String borrowDVDTitle = scanner.nextLine();
                    library.borrowItem(borrowDVDTitle);
                    break;

                case 5:
                    library.displayAllItemsOfType(Book.class);
                    break;

                case 6:
                    library.displayAllItemsOfType(DVD.class);
                    break;

                case 0:
                    System.out.println("Exiting the Library. Goodbye!");
                    break;

                default:
                    System.out.println("\n==============================================");
                    System.out.println("|Invalid choice. Please enter a valid option.|");
                    System.out.println("==============================================");
            }

        } while (choice != 0);

        scanner.close();
    }
}