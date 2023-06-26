import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;

public class CoffeeShopManager {
    private CoffeeFlavors flavors;
    private Bag bag;
    private Payment payment;
    private int orderNumber;

    public CoffeeShopManager() {
        flavors = new CoffeeFlavors();
        bag = new Bag();
        payment = new Payment(0.0);
        orderNumber = 0;
    }

    public void run() {
        String message_welcome = "\"Welcome to our coffee shop!\"";
        String message_options = "Choose option:\n1. Place order / add item\n2. Summarize your order\n3. Cancel an item" +
                "\n4. Empty/restart bag\n5. Pay\n6. Exit";
        JOptionPane.showMessageDialog(null, message_welcome);
        while (true) {
            try{
                int option = Integer.parseInt(showInputDialog(null, message_options, "CoffeShop Manager", JOptionPane.QUESTION_MESSAGE));
                switch (option) {
                    case 1:
                        placeOrder();
                        break;
                    case 2:
                        summarizeOrder();
                        break;
                    case 3:
                        cancelItem();
                        break;
                    case 4:
                        cancelProcess();
                        break;
                    case 5:
                        pay();
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Thank you for visiting our coffee shop!");
                        return;
                    default:
                        JOptionPane.showMessageDialog(null, "This option doesn't exists,\nplease try again");
                }
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter a valid Integer");
            }
        }
    }

    private void placeOrder() {
        flavors.listFlavors();
        try {
            int flavorOption = Integer.parseInt(showInputDialog(null, "What flavor (number) would you like to add?"));
            int quantity = Integer.parseInt(showInputDialog(null, "How many cups do you want?"));
            bag.addItem(flavors.getFlavor(flavorOption), quantity, flavors.getPrice(flavorOption));
            JOptionPane.showMessageDialog(null, "Item added into the bag", "Done!", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter a valid Integer");
        }
    }

    private void summarizeOrder() {
        bag.summarizeOrder();
    }

    private void cancelItem() {
        bag.cancelItem();
    }

    private void cancelProcess() {
        bag.cleanBagOrder();
        orderNumber = 0;
        //"Process canceled"
    }

    private double ammountToPay() {
        double totalToPay = bag.summarizeOrder();
        return totalToPay;
    }
    private void pay() {
        if (ammountToPay() != 0.0){
            String paymentOption = payment.setPaymentOption();
            boolean paymentResult = payment.verifyPayment();
            if (paymentResult) {
                orderNumber = (int) (Math.random() * 100000);
                JOptionPane.showMessageDialog(null, "Yor payment by: " + paymentOption + " was processed\nYour order number is: "+ orderNumber, "Order Finished!", JOptionPane.INFORMATION_MESSAGE);
                bag.cleanBagOrder();//to clear the bag to next client
            } else {
                JOptionPane.showMessageDialog(null, "Yor payment by: " + paymentOption + " was rejected", "Warning!", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Bag is empty!", "NO Payment to process!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}