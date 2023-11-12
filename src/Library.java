import java.util.ArrayList;
import java.util.List;


class Library {
    private List<Item> items;

    public Library() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getTitle() + " added to the library.");
    }

    public void borrowItem(String title) {
        for (Item item : items) {
            if (item.getTitle().equals(title) && item.isAvailable()) {
                item.setAvailable(false);
                System.out.println("You have borrowed " + title + ".");
                return;
            }
        }
        System.out.println("Sorry, " + title + " is not available for borrowing.");
    }

    public void displayAllItems() {
        for (Item item : items) {
            item.displayInfo();
        }
    }
}