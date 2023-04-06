import java.util.Random;
import java.util.Scanner;

/**
 * DicePlayer class, to select a type of Dice and the number of dices to roll.
 *
 * It has two methods: run() and rollDice();
 *      - run() informs and verifies the user's choice. If: 0, 4, 6, 8, 10, 12 or Invalid option.
 *      - rollDice() has as paramenter the diceType selected by user. Asks to inform number of dices.
 *      and returns it as the result of the roll.
 */
public class DicePlayer {
    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n\tSelect Type of dice: ");
            System.out.println("Tetrahedron(4), Cube(6), Octahedron(8), Trapezohedron(10), Dodecahedron(12),");
            System.out.println("0. Exit DicePlayer");
            int choiceDiceType = scanner.nextInt();
            if (choiceDiceType == 0){
                System.out.println("Goodbye!");
                return;
            }
            //if choice match the kind of dices (4,6,8,10,12):
            if (choiceDiceType == 4 || choiceDiceType == 6 || choiceDiceType == 8 || choiceDiceType == 10 || choiceDiceType == 12){
                System.out.println("* * * * * * * * * * * * * * *");
                rollDice(choiceDiceType);
            } else{
                System.out.println("Invalid choice!");
            }
        }
    }

     private void rollDice(int diceType) {
        int totalPoints = 0;
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of dices to play: ");
        int dicesToPlay = scanner.nextInt();

        int[] results = new int[dicesToPlay]; //creates a new integer array (empty) of size "dicesToPlay"
        //iteracts the number of dices to play:
        for (int i = 0; i < dicesToPlay; i++) {
            results[i] = random.nextInt(diceType) + 1; //Random from "0+1" to diceType, inclusive
            System.out.println("Dice " + (i + 1) + ": " + results[i] + " points"); //shows result
            totalPoints += results[i]; //calculates total points
        }
        System.out.println("TOTAL POINTS: " + totalPoints); //informs sum of total points
         System.out.println("* * * * * * * * * * * * * * *");
    }
}