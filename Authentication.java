import java.util.*;

public class Authentication{
    public Authentication(){
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
            authCheck = true;
        }
        else {
            System.out.println("Login failed, please try again");
            authCheck = false;
        }
    }
    
    public boolean getAuthCheck(){
        return authCheck;
    }

    private boolean authCheck;
}