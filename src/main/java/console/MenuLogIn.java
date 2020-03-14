package console;

public class MenuLogIn {

    private static final StringBuilder builder = new StringBuilder();

    public static void showLogInMenu() {
        builder.delete(0, builder.length());
        builder.append("===============================\n");
        builder.append("|         Booking App         |\n");
        builder.append("===============================\n");
        builder.append("| 1. Log in                   |\n");
        builder.append("| 2. Create new account       |\n");
        builder.append("| 3. Exit                     |\n");
        builder.append("===============================\n");
        System.out.println(builder.toString());
    }

    public static void showLogIn() {
        builder.delete(0, builder.length());
        builder.append("=========== WELCOME, ENTER YOUR INFO ===========");
        System.out.println(builder);
    }

    public static void showRegister() {
        builder.delete(0, builder.length());
        builder.append("================== JOINT TO US ==================");
        System.out.println(builder);
    }

    public static void successfullyLogin() {
        builder.delete(0, builder.length());
        builder.append("===============================\n");
        builder.append("|    log in is successfully   |\n");
        builder.append("===============================\n");
        System.out.println(builder.toString());
    }

    public static void successfullyCreatedLogin() {
        builder.delete(0, builder.length());
        builder.append("=================================\n");
        builder.append("|your login created successfully|\n");
        builder.append("=================================\n");
        System.out.println(builder.toString());
    }
}
