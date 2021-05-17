package system.ui;

import java.util.Scanner;

public class UI {
  private Scanner scanner = new Scanner(System.in);

  public void displayLn(String message) {
    System.out.println(message);
  }

  public void displayLn(int message) {
    System.out.println(message);
  }

  public void display(String message) {
    System.out.print(message);
  }

  public void display(int message) {
    System.out.print(message);
  }

  public int getInt() {
    return validateInt();
  }

  public int validateInt() {
    while (!scanner.hasNextInt()) {
      display("Please enter a number: ");
      scanner.next();
    }
    int number = scanner.nextInt();
    scanner.nextLine();
    return number;
  }

  public String getString() {
    return scanner.nextLine();
  }

  public int validateRange(int maxRange) {
    int choice = getInt();
    while (choice <= 0 || choice > maxRange) {
      displayLn("Out of range, try again");
      choice = getInt();
    }
    return choice;
  }
}
