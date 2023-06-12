import javax.swing.*;
import java.util.Random;

import static javax.swing.JOptionPane.showInputDialog;

/**
 * The Payment class stores information about the payment and order, and provides methods to verify the payment and authorize the order.
 * The setPaymentOption method sets the payment option.
 * The verifyPayment method generates a random boolean to simulate payment verification.
 * The authorizeOrder method checks whether the payment has been verified, and if so, generates a random order number and prints it to the console.
 */
public class Payment {
    private double amount;
    private boolean verified;

    public Payment(double amount) {
        this.amount = amount;
    }

    public String setPaymentOption() {
        String Option = "";
        String message_payment = "How do you want to pay?\n1. Cash\n2. Credit card\n";
        int paymentOption = Integer.parseInt(showInputDialog(null, message_payment));
        switch (paymentOption){
            case 1 :
                Option = "Cash";
                break;
            case 2 :
                Option = "Credit card";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid option, please try again");
        }
        return Option;
    }

    public boolean verifyPayment() {
        Random random = new Random();
        verified = random.nextBoolean();
        return verified;
    }
}
