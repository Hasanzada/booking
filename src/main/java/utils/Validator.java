package utils;

public class Validator {

    public static boolean getValidUser(String username){
        if(username != null && (username.length() >= 5 && username.length() < 20)){
            return true;
        }else{
            System.out.println("username must be equal or greater 5 characters and less than 20 characters");
            System.out.println("username: ");
            return false;
        }
    }

    public static boolean getValidPassword(String password){
        if(password != null && (password.length() > 8 && password.length() < 16)){
            return true;
        }else{
            System.out.println("password must be equal or greater 8 characters and less than 16 characters");
            System.out.println("password: ");
            return false;
        }
    }



}
