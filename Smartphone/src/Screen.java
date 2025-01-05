import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Screen {
    private ButtonClickListener listener;
    private JButton button1, button2, button3, button4;
    private JLabel lb2;
    public int cmode=0,value=0; //screen music phoneCall agenda web

    //初始螢幕
    public Screen(ButtonClickListener listener) {
        this.listener = listener;

        //Jframe設定
        JFrame frame = new JFrame("Your New Smartphone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 800);

        //JPanel設定
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout for centering and spacing
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // Add vertical spacing between buttons
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;

        //設定JLabel lb2
        //用getCurrentDate呼叫TimeDate得到現在時間 並用lb2顯示
        TimeDate timeDate = new TimeDate();
        lb2 = new JLabel(timeDate.getCurrentDate()+" "+timeDate.getCurrentTime(),JLabel.LEFT);
        Dimension labelsize = new Dimension(200, 100);
        lb2.setPreferredSize(labelsize);
        lb2.setFont(new Font("Serif", Font.PLAIN, 27));

        //呼叫按鈕設定的方法
        buttonSetup();

        //按鈕偵測+回傳數值到Class Smartphone
        //按下按鈕後frame.dispose()會消除視窗 釋放程式記憶體
        button1.addActionListener(e -> {
            frame.dispose();
            if (listener != null) {
                    listener.onButtonClicked(1);
                }
            });
        button2.addActionListener(e -> {
            frame.dispose();
            if (listener != null) {
                    listener.onButtonClicked(2);
                }
            });
        button3.addActionListener(e -> {
            frame.dispose();
            if (listener != null) {
                    listener.onButtonClicked(3);
                }
            });
        button4.addActionListener(e -> {
            frame.dispose();
            if (listener != null) {
                    listener.onButtonClicked(4);
                }
            });

        //新增設定好的物件到JPanel上
        gbc.gridy = 0;
        panel.add(lb2, gbc);
        gbc.gridy = 1;
        panel.add(button1, gbc);
        gbc.gridy = 2;
        panel.add(button2, gbc);
        gbc.gridy = 3;
        panel.add(button3, gbc);
        gbc.gridy = 4;
        panel.add(button4, gbc);

        //將JPanel新增到JFrame上
        frame.add(panel);
        //顯示JFrame
        frame.setVisible(true);
    }

    //按鈕1~4設定
    public void buttonSetup(){
        button1 = new JButton();
        try { //導入圖片
            Image img = ImageIO.read(getClass().getResource("image/music.png"));
            button1.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        button2 = new JButton();
        try { //導入圖片
            Image img = ImageIO.read(getClass().getResource("image/phonecall.png"));
            button2.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        button3 = new JButton();
        try { //導入圖片
            Image img = ImageIO.read(getClass().getResource("image/agenda.png"));
            button3.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        button4 = new JButton();
        try { //導入圖片
            Image img = ImageIO.read(getClass().getResource("image/web.png"));
            button4.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //設定按鈕1~4的大小
        Dimension buttonSize = new Dimension(200, 100);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);
    }
    /*
    //隱藏+展示所有按鈕
    public void hideAllButtons() {
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
    }
    public void showAllButtons() {
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(true);
    }*/
    public static void main(String[] args) throws InterruptedException {
        ValueReceiver receiver = new ValueReceiver();
        new Screen(receiver);
    }
}

