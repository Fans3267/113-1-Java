import java.util.ArrayList;
import java.util.List;

/**
 * The Bag class contains a list of items and prices, which can be added to or removed from.
 * The addItem method adds an item and its price to the bag.
 * The summarizeOrder method prints a summary of the items and prices in the bag to the console, along with the total price.
 * The getTotal method returns the total price of the items in the bag.
 * The cancelItem method removes an item from the bag at a given index.
 * The cancelOrder method removes all items from the bag.
 */
public class Bag {
    private List<String> items;
    private List<Double> prices;
    private List<Integer> quantities;

    public Bag() {
        items = new ArrayList<>();
        prices = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    public void addItem(String item, int quantity, double price) {
        items.add(item);
        prices.add(price);
        quantities.add(quantity);
    }

    public double summarizeOrder() {
        double total = 0;
        if (items.isEmpty()) {
            System.out.println("No items in bag");
        } else {
            System.out.println("Here's a summary of your order:");
            System.out.println("Qt.:    Flavors:    Prices:");
            //total = 0;
            for (int i = 0; i < items.size(); i++) {
                System.out.println(quantities.get(i) + " __   " + items.get(i) + " __  $" + quantities.get(i) * prices.get(i));
                total += quantities.get(i) * prices.get(i);
            }
            System.out.println("Total: $" + total);
        }
        return total;
    }

    public void cancelItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            prices.remove(index);
            System.out.println("Item removed from bag");
        } else {
            System.out.println("Invalid index");
        }
    }

    public void cleanBagOrder() {
        items.clear();
        prices.clear();
        quantities.clear();
        System.out.println("...Process Finished");
    }
}


