import javax.swing.*;
import java.awt.*;



public class Screen {
    public Screen() {
        JFrame frame = new JFrame("Basic Window with Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 800);

        // Create a panel to hold the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout for centering and spacing
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // Add vertical spacing between buttons
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;

        // Add buttons to the panel
        JButton button1 = new JButton("Music Player");
        JButton button2 = new JButton("Phone Call");
        JButton button3 = new JButton("Agenda App");
        JButton button4 = new JButton("Web Browser");

        // Set button sizes
        Dimension buttonSize = new Dimension(200, 100);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);

        //時間方法及其回傳 time method and the return value of it
        TimeDate timeDate = new TimeDate();
        String datenow = timeDate.getCurrentDate();
        String timenow = timeDate.getCurrentTime();
        System.out.println(datenow +"\n"+ timenow);

        // Add buttons to the panel with constraints
        gbc.gridy = 0;
        panel.add(button1, gbc);
        gbc.gridy = 1;
        panel.add(button2, gbc);
        gbc.gridy = 2;
        panel.add(button3, gbc);
        gbc.gridy = 3;
        panel.add(button4, gbc);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        new Screen();

        Smartphone smartphone = new Smartphone();
        smartphone.run();
    }



}

