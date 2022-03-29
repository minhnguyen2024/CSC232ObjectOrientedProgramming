import java.awt.*;

import javax.swing.*;

public class GUI {
    public GUI(){
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
        frame.setTitle("Basic GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        label.setText("Number of clicks: "+ct);

        JButton testButton = new JButton();
        testButton.setText("This is a test button");
        testButton.addActionListener(event -> {
            ct++;
            label.setText("Number of clicks: "+ct);
        });

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(testButton);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
    }


    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 400;
    //private final int DELAY = 1000;
    private int ct = 0;

}
