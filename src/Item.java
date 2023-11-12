abstract class Item {
    private String title;
    private int year;
    private boolean available;

    public Item(String title, int year) {
        this.title = title;
        this.year = year;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract void displayInfo();
}
