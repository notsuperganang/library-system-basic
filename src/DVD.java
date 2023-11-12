class DVD extends Item {
    private String director;

    public DVD(String title, int year, String director) {
        super(title, year);
        this.director = director;
    }

    @Override
    public void displayInfo() {
        System.out.println("DVD: " + getTitle() + " directed by " + director + " (" + getYear() + ")");
    }
}
