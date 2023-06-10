import javax.swing.*;
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
            JOptionPane.showMessageDialog(null, "No items in bag", "Summary:", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder bag_summary = new StringBuilder("Nr.     Qt.(s):    Flavor(s):    Amount(s): ");
            for (int i = 0; i < items.size(); i++) {
                bag_summary.append("\n" + i+1 + "      " + quantities.get(i) + "     _       " + items.get(i) + "      _     $" + String.format("%.2f", quantities.get(i) * prices.get(i)));
                total += quantities.get(i) * prices.get(i);
            }
            bag_summary.append("\nTotal: $" + String.format("%.2f", total));
            JOptionPane.showMessageDialog(null, new String(bag_summary), "Here's a summary of your order:", JOptionPane.INFORMATION_MESSAGE);
        }
        return total;
    }

    public void cancelItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            prices.remove(index);
            quantities.remove(index);
            JOptionPane.showMessageDialog(null, "Item removed from bag");
        } else {
            JOptionPane.showMessageDialog(null, "Index out of Range", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cleanBagOrder() {
        items.clear();
        prices.clear();
        quantities.clear();
        JOptionPane.showMessageDialog(null, "...All items removed\nYou can restart the process or exit", "Empty", JOptionPane.WARNING_MESSAGE);
    }
}


