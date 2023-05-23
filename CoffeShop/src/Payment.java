import java.util.Random;
import java.util.Scanner;
/**
 * The Payment class stores information about the payment and order, and provides methods to verify the payment and authorize the order.
 * The setPaymentOption method sets the payment option.
 * The verifyPayment method generates a random boolean to simulate payment verification.
 * The authorizeOrder method checks whether the payment has been verified, and if so, generates a random order number and prints it to the console.
 */
public class Payment {
    private String paymentOption;
    private double amount;
    private boolean verified;
    private int orderNumber;


    public Payment(double amount) {
        this.amount = amount;
    }

    public void setPaymentOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How do you want to pay?");
        System.out.println("1. Cash");
        System.out.println("2. Credit card");
        int paymentOption = scanner.nextInt();
        //double amount = bag.summarizeOrder();
    }

    public boolean verifyPayment() {
        Random random = new Random();
        verified = random.nextBoolean();
        return verified;
    }
    public void authorizeOrder() {
        if (verified) {
            orderNumber = (int) (Math.random() * 100000);
            System.out.println("Order authorized. Your order number is: " + orderNumber);
        } else {
            System.out.println("Payment not verified. Order not authorized");
        }

    }
}
