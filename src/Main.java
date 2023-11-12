import java.util.Scanner;

public class Main {

    private static int getValidNumberInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("================================================");
                System.out.println("|  Invalid input. Please enter a valid number. |");
                System.out.println("================================================");
            }
        }
    }

    private static String getValidStringInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isBlank()) {
                return input;
            } else {
                System.out.println("=================================================");
                System.out.println("|Invalid input. Please enter a non-empty string.|");
                System.out.println("=================================================");
            }
        }
    }

    private static String getNonExistingTitleInput(Scanner scanner, Library library, String prompt) {
        while (true) {
            System.out.print(prompt);
            String title = scanner.nextLine().trim().toLowerCase();

            if (!title.isBlank()) {
                if (!library.isTitleExists(title)) {
                    return title;
                } else {
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("  A book with the title " + title + " already exists");
                    System.out.println("-----------------------------------------------------------");
                }
            } else {
                System.out.println("=================================================");
                System.out.println("|Invalid input. Please enter a non-empty string.|");
                System.out.println("=================================================");
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n<================ Welcome to the Library! ================> ");

        int choice;
        do {
            System.out.println("\n---------------------");
            System.out.println("        Menu:");
            System.out.println("---------------------");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Add DVD");
            System.out.println("4. Borrow DVD");
            System.out.println("5. Display All Books");
            System.out.println("6. Display All DVD");
            System.out.println("7. Display All Items");
            System.out.println("0. Exit");
            choice = getValidNumberInput(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    System.out.println("\n                      Adding Book!");
                    System.out.println("-----------------------------------------------------------");
                    String title = getNonExistingTitleInput(scanner, library, "| Enter book title       : ");
                    int year = getValidNumberInput(scanner, "| Enter book year        : ");
                    String author = getValidStringInput(scanner, "| Enter book author      : ");
                    int pages = getValidNumberInput(scanner, "| Enter book Pages       : ");
                    System.out.println("-----------------------------------------------------------");

                    Book newBook = new Book(title, year, author, pages);
                    library.addItem(newBook);
                    break;

                case 2:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowItem(borrowTitle);
                    break;

                case 3:
                    System.out.println("\n                        Adding DVD!");
                    System.out.println("-----------------------------------------------------------");
                    String dvdTitle = getNonExistingTitleInput(scanner, library, "| Enter DVD title         : ");
                    int dvdYear = getValidNumberInput(scanner, "| Enter DVD year          : ");
                    String dvdDirector = getValidStringInput(scanner, "| Enter DVD director      : ");
                    int dvdDur = getValidNumberInput(scanner, "| Enter DVD duration      : ");
                    System.out.println("-----------------------------------------------------------");
                    DVD newDVD = new DVD(dvdTitle, dvdYear, dvdDirector, dvdDur);
                    library.addItem(newDVD);
                    break;

                case 4:
                    String borrowDVDTitle = getValidStringInput(scanner, "Enter DVD title to borrow : ");
                    library.borrowItem(borrowDVDTitle);
                    break;

                case 5:
                    library.displayAllItemsOfType(Book.class);
                    break;

                case 6:
                    library.displayAllItemsOfType(DVD.class);
                    break;

                case 7:
                    library.displayAllItems();
                    break;

                case 0:
                    System.out.println("\n-----------------------------------------------------------");
                    System.out.println("              Exiting the Library. Goodbye!");
                    System.out.println("-----------------------------------------------------------");
                    break;

                default:
                    System.out.println("=================================================");
                    System.out.println("|  Invalid choice. Please enter a valid option. |");
                    System.out.println("=================================================");
            }

        } while (choice != 0);

        scanner.close();
    }
}