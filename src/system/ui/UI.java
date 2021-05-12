package system.ui;

import java.util.Scanner;

public class UI {
    private Scanner scanner = new Scanner(System.in);

    public void display(String message) {
        System.out.println(message);
    }

    public void display(int message) {
        System.out.println(message);
    }

    public int getInt() {
        return scanner.nextInt();
    }

    public String getString() {
        return scanner.nextLine();
    }
}
