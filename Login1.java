import java.awt.*;
import javax.swing.*;

public class Login1 {

    public Login1(){
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame .setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login");
        frame.setLayout(new FlowLayout());
        
        JLabel usernameLabel = new JLabel("Enter username");
        usernameLabel.setBounds(10,50,80,25);
        frame.add(usernameLabel);

        JTextField username = new JTextField(50);
        username.setBounds(10,50,80,25);
        frame.add(username);

        JLabel passwordLabel = new JLabel("Enter password");
        passwordLabel.setBounds(10,50,80,25);
        frame.add(passwordLabel);

        JPasswordField password = new JPasswordField(50);
        password.setBounds(10,50,80,25);
        frame.add(password);

        JLabel successfulLogin = new JLabel("Successful Login");
        successfulLogin.setBounds(10,50,80,25);

        JLabel failedLogin = new JLabel("Failed Login");
        successfulLogin.setBounds(10,50,80,25);

        JButton loginButton = new JButton();
        loginButton.setBounds(10,50,80,25);
        loginButton.setText("Login");
        loginButton.addActionListener(event -> {
            if (UserDatabase.userAuthentication(username.getText(), password.getText())){
                frame.add(successfulLogin);
                System.out.println("Successful Login");
                GUI gui = new GUI();
            } else{
                frame.add(failedLogin);
                System.out.println("Failed Login");
                username.setText("");
                password.setText("");
            }
        });
        frame.add(loginButton);

        JButton createAccButton = new JButton();

        createAccButton.setBounds(10,50,80,25);
        createAccButton.setText("Create New Account");
        frame.add(createAccButton);
        createAccButton.addActionListener(event ->{
            JFrame createNewAccount = new JFrame();
            createNewAccount.setSize(FRAME_WIDTH, FRAME_HEIGHT);
            createNewAccount.setVisible(true);
            createNewAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            createNewAccount.setTitle("Create New Account");
            createNewAccount.setLayout(new FlowLayout());

            JTextField newUsernameText = new JTextField(50);
            createNewAccount.add(new JLabel("Enter new username"));
            createNewAccount.add(newUsernameText);

            JPasswordField newPasswordText1 = new JPasswordField(50);
            createNewAccount.add(new JLabel("Enter new password"));
            createNewAccount.add(newPasswordText1);

            JPasswordField newPasswordText2 = new JPasswordField(50);
            createNewAccount.add(new JLabel("Confirm new password"));
            createNewAccount.add(newPasswordText2);
            
            JButton newAccConfirmButton = new JButton();
            newAccConfirmButton.setText("Confirm New Account");
            createNewAccount.add(newAccConfirmButton);
            newAccConfirmButton.addActionListener(confirm ->{
                String newUsername = newUsernameText.getText();
                String newPassword2 = newPasswordText2.getText();
                String newPassword1 = newPasswordText1.getText();
                if (newPassword1.equals(newPassword2)){
                    UserDatabase.addUser(newUsername, newPassword2);
                }
                newUsernameText.setText("");
                newPasswordText1.setText("");
                newPasswordText2.setText("");
            });

            //create UserDatabase check
            JButton databaseDisplay = new JButton();
            databaseDisplay.setText("Display Database");
            createNewAccount.add(databaseDisplay);
            databaseDisplay.addActionListener(display->{
                UserDatabase.printHashtable();
                JTextField newUserDisplay = new JTextField(50);
                newUserDisplay.setText(UserDatabase.data.toString());
                createNewAccount.add(newUserDisplay);
            });
        });
    }
    private final int FRAME_WIDTH = 750;
    private final int FRAME_HEIGHT = 300;
}


