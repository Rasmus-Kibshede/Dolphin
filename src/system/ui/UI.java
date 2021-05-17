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

  public int getInt(String errorMessage) {
    int number = getValidateInt(errorMessage);
    scanner.nextLine();
    return number;
  }

  //Rasmus
  public int getValidateInt(String errorMessage) {
    while (!scanner.hasNextInt()) {
      display(errorMessage);
      scanner.next();
    }
    return scanner.nextInt();
  }

  public String getString() {
    return scanner.nextLine();
  }

  //Rasmus
  public int validateRange(int maxRange) {
    int choice = getInt("Please enter a number: ");

    while (choice <= 0 || choice > maxRange) {
      displayLn("Out of range, try again");
      choice = getInt("Please enter a number: ");
    }

    return choice;
  }

  public char getChar() {
    return scanner.nextLine().charAt(0);
  }

/*
  public char validateChar(String errorMessage){
    while (!scanner.hasNext()) {
      display(errorMessage);
      scanner.next();
    }
    return getChar();
  }
 */

  //Rasmus
  /*
  public char validateChar(char char1, char char2, char charChoice, String errorMessage) {
    while (!(charChoice == char1 || charChoice == char2)) {
      display(errorMessage);
      charChoice = getChar();
    }

    return charChoice;
  }
   */

  /*
  public LocalDate getDate() {
  }
   */
}
