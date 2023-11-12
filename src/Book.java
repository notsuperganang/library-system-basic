class Book extends Item {
    private String author;
    private int pages;

    public Book(String title, int year, String author, int pages) {
        super(title, year);
        this.author = author;
        this.pages = pages;
    }

    @Override
    public void displayInfo() {
        String status = isAvailable() ? "Available for borrowing" : "Not available for borrowing";
        System.out.println("\n===========================================================");
        System.out.println("Book         : " + getTitle());
        System.out.println("Author       : " + author);
        System.out.println("Year         : " + getYear());
        System.out.println("Pages        : " + pages);
        System.out.println("Status       : " + status);
        System.out.println("===========================================================");
    }
}
