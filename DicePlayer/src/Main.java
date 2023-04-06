
/**
 * The Main class instances an Object of DicePlayer() class,
 * then calls its run() method.
 */

public class Main {
    public static void main(String[] args) {
        System.out.print("\tWELCOME TO DICE PLAYER!\n");
        DicePlayer dicePlayer = new DicePlayer();
        dicePlayer.run();
    }
}