import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showInputDialog;

/**
 * The Bag class contains a list of items and prices, which can be added or removed.
 * The addItem method adds an item and its price to the bag.
 * The summarizeOrder method prints a summary of the items and prices in the bag to the console, along with the total price.
 * The cancelItem method removes an item from the bag at a given index.
 * The cleanBagOrder method removes all items from the bag.
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
            int j = 1;
            StringBuilder bag_summary = new StringBuilder("Nr.     Qt.(s):    Flavor(s):    Amount(s): ");
            for (int i = 0; i < items.size(); i++) {
                bag_summary.append("\n" + j + "      " + quantities.get(i) + "     _       " + items.get(i) + "      _     $" + String.format("%.2f", quantities.get(i) * prices.get(i)));
                j++;
                total += quantities.get(i) * prices.get(i);
            }
            bag_summary.append("\nTotal: $" + String.format("%.2f", total));
            JOptionPane.showMessageDialog(null, new String(bag_summary), "Here's a summary of your order:", JOptionPane.INFORMATION_MESSAGE);
        }
        return total;
    }

    public void cancelItem() {
        if (items.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No items in bag", "Summary:", JOptionPane.INFORMATION_MESSAGE);
        } else {
            //int index;
            summarizeOrder();
            int index = Integer.parseInt(showInputDialog(null, "Which item number do you want to cancel?", "Cancel", JOptionPane.WARNING_MESSAGE));
            if (index >= 0 && index < items.size()) {
                items.remove(index-1);
                prices.remove(index-1);
                quantities.remove(index-1);
                JOptionPane.showMessageDialog(null, "Item removed from bag");
                summarizeOrder();
            } else {
                JOptionPane.showMessageDialog(null, "Index out of Range", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void cleanBagOrder() {
        items.clear();
        prices.clear();
        quantities.clear();
        JOptionPane.showMessageDialog(null, "...Bag was empty\nReady to new process", "Empty", JOptionPane.WARNING_MESSAGE);
    }
}


