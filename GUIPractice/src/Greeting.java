import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Greeting {
    public Greeting(){
        JFrame frame  = new JFrame();
        frame.setSize(800, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField textField = new JTextField(25);
        textField.setText("Click a Button!");
        frame.add(textField);

        JButton sayHello = new JButton();
        sayHello.setText("Say Hello!");
        frame.add(sayHello);
        sayHello.addActionListener(event -> textField.setText("Hello World!"));

        JButton sayGoodBye = new JButton();
        sayGoodBye.setText("Say GoodBye!");
        frame.add(sayGoodBye);
        sayGoodBye.addActionListener(event -> textField.setText("Good Bye!"));
    }
}
