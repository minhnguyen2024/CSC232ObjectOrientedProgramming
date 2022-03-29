import java.util.Scanner;

import java.util.*;

public class TerminalLogin {

    public TerminalLogin(){
        while (!authentication()){
            authentication();
        }
    }

    public boolean authentication(){
        Hashtable <String, String> auth = new Hashtable<String, String>();
        auth.put("hello123", "minhnguyen_2024");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String usernameInput = sc.next();

        System.out.print("Enter your password: ");
        String passwordInput = sc.next();
    
        sc.close();

        String usernameAuth = auth.get(passwordInput);

        if (usernameInput.equals(usernameAuth)){
            System.out.println("Successful Login");
            return true;
        }
        else {
            System.out.println("Login failed, please try again");
            return false;
        }
    }
}
