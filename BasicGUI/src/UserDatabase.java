import java.util.*;

public class UserDatabase {
    static Hashtable<String, String> data = new Hashtable<String, String>();

    public UserDatabase(){

    }

    public static void addUser(String username, String password){
        data.put(password, username);
    }

    public static boolean userAuthentication(String usernameInput, String passwordInput){
        String usernameAuth = data.get(passwordInput);
        if (usernameInput.equals(usernameAuth)){
            return true;
        }
        else {
            return false;
        }
    }

    public static void printHashtable(){
        System.out.println(data.toString());
    }
}
