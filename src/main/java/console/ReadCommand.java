package console;

import java.util.Scanner;

public class ReadCommand {

    public static int getCommand(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
