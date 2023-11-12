import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Item> items;

    public Library() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        String title = item.getTitle();

        // Memeriksa apakah buku dengan judul yang sama sudah ada dalam koleksi
        if (isTitleExists(title)) {
            System.out.println("\n-----------------------------------------------------------");
            System.out.println("    Sorry, a book with the title " + title + " already exists in the library.");
            System.out.println("-----------------------------------------------------------");
        } else {
            items.add(item);
            System.out.println("\n-----------------------------------------------------------");
            System.out.println("\t    " + title + " added to the library.");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public boolean isTitleExists(String title) {
        for (Item item : items) {
            if (item.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public void borrowItem(String title) {
        for (Item item : items) {
            if (item.getTitle().equals(title) && item.isAvailable()) {
                item.setAvailable(false);
                System.out.println("\n-----------------------------------------------------------");
                System.out.println("            You have borrowed " + title + ".");
                System.out.println("-----------------------------------------------------------");
                return;
            }
        }
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("    Sorry, " + title + " is not available for borrowing.");
        System.out.println("-----------------------------------------------------------");
    }

    public void displayAllItems() {
        if (items != null && !items.isEmpty()) {
            for (Item item : items) {
                item.displayInfo();
            }
        } else {
            System.out.println("\n-----------------------------------------------------------");
            System.out.println("        No items of type DVD have been added yet!");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void displayAllItemsOfType(Class<? extends Item> itemType) {
        boolean found = false;

        for (Item item : items) {
            // Memeriksa apakah objek bertipe itemType
            if (itemType.isInstance(item)) {
                item.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("\n-----------------------------------------------------------");
            System.out.println("        No items of type " + itemType.getSimpleName() + " have been added yet!");
            System.out.println("-----------------------------------------------------------");
        }
    }

}