package console;

public class MenuLogIn {

    private static final StringBuilder builder = new StringBuilder();

    public static void showLogInMenu(){
        builder.delete(0,builder.length());
        builder.append(" =============================\n");
        builder.append("|         Booking App         |\n");
        builder.append(" =============================\n");
        builder.append("| 1. Log IN                   |\n");
        builder.append("| 2. Create new account       |\n");
        builder.append("| 3. Exit                     |\n");

        System.out.println(builder.toString());
    }

    public static void showLogIn(){
        builder.delete(0,builder.length());
        builder.append("=========== WELCOME, ENTER YOUR INFO ===========");
        System.out.println(builder);
    }

    public static void showRegister(){
        builder.delete(0,builder.length());
        builder.append("================== JOINT TO US ==================");
        System.out.println(builder);
    }
}
