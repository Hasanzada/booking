package utils;

public class Validator {
    public static boolean getValidation(String str){
        return str != null && (str.length() >= 5 && str.length() < 20);
    }
}
