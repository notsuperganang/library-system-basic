import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Item> items;

    public Library() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println("\n---------------------------------------------------------");
        System.out.println("\t    " + item.getTitle() + " added to the library.");
        System.out.println("---------------------------------------------------------");
    }

    public void borrowItem(String title) {
        for (Item item : items) {
            if (item.getTitle().equals(title) && item.isAvailable()) {
                item.setAvailable(false);
                System.out.println("\n---------------------------------------------------------");
                System.out.println("            You have borrowed " + title + ".");
                System.out.println("---------------------------------------------------------");
                return;
            }
        }
        System.out.println("\n---------------------------------------------------------");
        System.out.println("    Sorry, " + title + " is not available for borrowing.");
        System.out.println("---------------------------------------------------------");
    }

    public void displayAllItems() {
        for (Item item : items) {
            item.displayInfo();
        }
    }

    public void displayAllItemsOfType(Class<? extends Item> itemType) {
        for (Item item : items) {
            // Memeriksa apakah objek bertipe itemType
            if (itemType.isInstance(item)) {
                item.displayInfo();
            }
        }
    }

}