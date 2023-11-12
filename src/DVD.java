class DVD extends Item {
    private String director;
    private int duration;

    public DVD(String title, int year, String director, int duration) {
        super(title, year);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public void displayInfo() {
        String status = isAvailable() ? "Available for borrowing" : "Not available for borrowing";
        System.out.println("\n===========================================================");
        System.out.println("DVD          : " + getTitle());
        System.out.println("Directed by  : " + director);
        System.out.println("Year         : " + getYear());
        System.out.println("Duration     : " + duration);
        System.out.println("Status       : " + status);
        System.out.println("===========================================================");

    }
}
