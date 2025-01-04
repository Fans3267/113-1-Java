import javax.swing.*;
import java.awt.*;

public class Screen {
    private ButtonClickListener listener;
    private JButton button1, button2, button3, button4;

    public Screen(ButtonClickListener listener) {
        this.listener = listener;

        JFrame frame = new JFrame("Your New Smartphone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 800);

        // Create a panel to hold the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout for centering and spacing
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // Add vertical spacing between buttons
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;

        // Initialize buttons as class-level variables
        button1 = new JButton("Music Player");
        button2 = new JButton("Phone Call");
        button3 = new JButton("Agenda App");
        button4 = new JButton("Web Browser");

        // Set button sizes
        Dimension buttonSize = new Dimension(200, 100);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);

        //按鈕偵測+回傳數值
        button1.addActionListener(e -> {
            if (listener != null) {
                listener.onButtonClicked(1);
                hideAllButtons();
            }
        });
        button2.addActionListener(e -> {
            if (listener != null) {
                listener.onButtonClicked(2);
                hideAllButtons();
            }
        });
        button3.addActionListener(e -> {
            if (listener != null) {
                listener.onButtonClicked(3);
                hideAllButtons();
            }
        });
        button4.addActionListener(e -> {
            if (listener != null) {
                listener.onButtonClicked(4);
                hideAllButtons();
            }
        });

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

    //(方法)隱藏+展示所有按鈕
    private void hideAllButtons() {
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
    }
    private void showAllButtons() {
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        ValueReceiver receiver = new ValueReceiver();
        new Screen(receiver);
    }
}

