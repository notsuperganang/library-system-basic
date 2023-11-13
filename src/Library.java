import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Item> items;

    public Library() {
        this.items = new ArrayList<>();
    }

    public void additempreset(Item item) {
        items.add(item);
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
        // Cek apakah judul sudah ada dalam daftar item
        boolean titleExists = false;
        for (Item item : items) {
            if (item.getTitle().equals(title)) {
                titleExists = true;
                break;
            }
        }

        if (!titleExists) {
            System.out.println("\n-----------------------------------------------------------");
            System.out.println("       Sorry, " + title + " is not in the library's catalog.");
            System.out.println("   To view the library catalog, please select option 7!.");
            System.out.println("-----------------------------------------------------------");
            return;
        }

        // Iterasi untuk meminjam item
        for (Item item : items) {
            if (item.getTitle().equals(title) && item.isAvailable()) {
                item.setAvailable(false);
                System.out.println("\n-----------------------------------------------------------");
                System.out.println("            You have borrowed " + title + ".");
                System.out.println("-----------------------------------------------------------");
                return;
            }
        }

        // Jika judul ada tetapi tidak tersedia
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
            System.out.println("              No items have been added yet!");
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