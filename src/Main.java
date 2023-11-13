import java.util.Scanner;

public class Main {

    private static int getValidNumberInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("|\t================================================");
                System.out.println("|\t|  Invalid input. Please enter a valid number. |");
                System.out.println("|\t================================================");
            }
        }
    }

    private static int getValidYear(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int Year = Integer.parseInt(scanner.nextLine());
                if (Year <= 2023 && Year >= 1) {
                    return Year;
                } else {
                    System.out.println("|\t================================================");
                    System.out.println("|\t|the year cannot exceed 2023 and be less than 1|");
                    System.out.println("|\t================================================");
                }
            } catch (NumberFormatException e) {
                System.out.println("|\t================================================");
                System.out.println("|\t|  Invalid input. Please enter a valid number. |");
                System.out.println("|\t================================================");
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
                System.out.println("|\t=================================================");
                System.out.println("|\t|Invalid input. Please enter a non-empty string.|");
                System.out.println("|\t=================================================");
            }
        }
    }

    private static String getNonExistingTitleInput(Scanner scanner, Library library, String prompt) {
        while (true) {
            System.out.print(prompt);
            String title = scanner.nextLine().trim();
            String temp = title;
            title.toLowerCase();

            if (!title.isBlank()) {
                if (!library.isTitleExists(title)) {
                    return title;
                } else {
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("  A book with the title " + temp + " already exists");
                    System.out.println("-----------------------------------------------------------");
                }
            } else {
                System.out.println("|\t=================================================");
                System.out.println("|\t|Invalid input. Please enter a non-empty string.|");
                System.out.println("|\t=================================================");
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        Book book1 = new Book("The Great Gatsby", 1925, "F. Scott Fitzgerald", 180);
        Book book2 = new Book("To Kill a Mockingbird", 1960, "Harper Lee", 281);
        Book book3 = new Book("1984", 1949, "George Orwell", 328);

        DVD dvd1 = new DVD("Inception", 2010, "Christopher Nolan", 148);
        DVD dvd2 = new DVD("The Matrix", 1999, "Lana Wachowski", 136);

        library.additempreset(dvd1);
        library.additempreset(dvd2);
        library.additempreset(book1);
        library.additempreset(book2);
        library.additempreset(book3);

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
            System.out.println("0. Exit\n");
            choice = getValidNumberInput(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    System.out.println("\n                      Adding Book!");
                    System.out.println("-----------------------------------------------------------");
                    String title = getNonExistingTitleInput(scanner, library, "| Enter book title       : ");
                    int year = getValidYear(scanner, "| Enter book year        : ");
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
                    int dvdYear = getValidYear(scanner, "| Enter DVD year          : ");
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
                    System.out.println("|\t=================================================");
                    System.out.println("|\t|  Invalid choice. Please enter a valid option. |");
                    System.out.println("|\t=================================================");
            }

        } while (choice != 0);

        scanner.close();
    }
}