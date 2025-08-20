interface Iterator<T> {
    boolean hasNext();
    T next();
}
interface Container<T> {
    Iterator<T> createIterator();
}
class Inventory implements Container<String> {
    private String[] items = {"Sword", "Shield", "Potion"};
    @Override
    public Iterator<String> createIterator() {
        return new InventoryIterator();
    }
    private class InventoryIterator implements Iterator<String> {
        int index = 0;

        public boolean hasNext() {
            return index < items.length;
        }

        public String next() {
            return items[index++];
        }
    }
}

// Client
public class iterator {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Iterator<String> iterator = inventory.createIterator();

        while (iterator.hasNext()) {
            System.out.println("Item: " + iterator.next());
        }
    }
}
