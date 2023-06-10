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
        Scanner scanner = new Scanner(System.in);
        String message_welcome = "\"Welcome to our coffee shop!\"";
        String message_options = "Choose option:\n1. Place an order\n2. Summarize your order\n3. Cancel an item" +
                "\n4. Empty/restart bag\n5. Pay\n6. Exit";
        JOptionPane.showMessageDialog(null, message_welcome);
        while (true) {
            int option = Integer.parseInt(showInputDialog(null, message_options));

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
                    JOptionPane.showMessageDialog(null, "Invalid option, please try again");
            }
        }
    }

    private void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        flavors.listFlavors();
        int flavorOption = Integer.parseInt(showInputDialog(null, "What flavor would you like to add?"));
        int quantity = Integer.parseInt(showInputDialog(null, "How many bags do you want?"));
        bag.addItem(flavors.getFlavor(flavorOption), quantity, flavors.getPrice(flavorOption));
        JOptionPane.showMessageDialog(null, "Item added into the bag", "Done!", JOptionPane.INFORMATION_MESSAGE);
    }

    private void summarizeOrder() {
        bag.summarizeOrder();
    }

    private void cancelItem() {
        Scanner scanner = new Scanner(System.in);
        bag.summarizeOrder();
        int itemOption = Integer.parseInt(showInputDialog(null, "Which item number do you want to cancel?", "Cancel", JOptionPane.WARNING_MESSAGE));
        bag.cancelItem(itemOption-1);
    }

    private void cancelProcess() {
        bag.cleanBagOrder();
        orderNumber = 0;
        //System.out.println("Process canceled");
    }

    private void pay() {
        payment.setPaymentOption();
        boolean paymentResult = payment.verifyPayment();

        if (paymentResult) {
            payment.authorizeOrder();
            bag.cleanBagOrder();//clear the bag to next client
        } else {
            System.out.println("Payment rejected, please try again or choose another payment option");
        }
    }
}