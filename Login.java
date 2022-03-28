import java.awt.*;

import javax.swing.*;

public class Login {
    public Login(){
        createBaseFrame();
        username();
        password();
        authentication();
        createNewAccount();
    }

    public void createBaseFrame(){
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame .setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login");
        frame.setLayout(new FlowLayout());
    }

    public void username(){
        JLabel usernameLabel = new JLabel("Enter username");
        usernameLabel.setBounds(10,50,80,25);
        frame.add(usernameLabel);

        JTextField username = new JTextField(50);
        username.setBounds(10,50,80,25);
        frame.add(username);
    }

    public void password(){
        JLabel passwordLabel = new JLabel("Enter password");
        passwordLabel.setBounds(10,50,80,25);
        frame.add(passwordLabel);

        JPasswordField password = new JPasswordField(50);
        password.setBounds(10,50,80,25);
        frame.add(password);
    }

    public void createNewAccount(){
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
            String newUsername = newUsernameText.getText();
            createNewAccount.add(newUsernameText);

            JPasswordField newPasswordText1 = new JPasswordField(50);
            createNewAccount.add(new JLabel("Enter new password"));
            String newPassword1 = newPasswordText1.getText();
            createNewAccount.add(newPasswordText1);

            JPasswordField newPasswordText2 = new JPasswordField(50);
            createNewAccount.add(new JLabel("Confirm new password"));
            String newPassword2 = newPasswordText1.getText();
            createNewAccount.add(newPasswordText2);
            
            JButton newAccConfirmButton = new JButton();
            newAccConfirmButton.setText("Confirm New Account");
            createNewAccount.add(newAccConfirmButton);
            newAccConfirmButton.addActionListener(confirm ->{
                if (newPassword1.equals(newPassword2)){
                    UserDatabase.addUser(newUsername, newPassword2);
                }
            });
        });
    }

    public void authentication(){
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
    }

    public void userDatabaseDisplay(){
        
    }
    private final int FRAME_WIDTH = 750;
    private final int FRAME_HEIGHT = 300;
    JFrame frame;
    JLabel usernameLabel;
    JTextField username;
    JLabel passwordLabel;
    JPasswordField password;
}
