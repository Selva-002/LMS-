package utils;

import java.util.*;

public class InputHelper {
    private static final Scanner sc = new Scanner(System.in);

    public static String getString(String message) {
        System.err.println(message);
        return sc.nextLine();
    }

    public static int getInt(String message) {
        while (true) {
            try {
                System.out.println(message);
                String input = sc.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
            }
        }

    }

}
