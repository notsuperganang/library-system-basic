class Book extends Item {
    private String author;

    public Book(String title, int year, String author) {
        super(title, year);
        this.author = author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book: " + getTitle() + " by " + author + " (" + getYear() + ")");
    }
}
