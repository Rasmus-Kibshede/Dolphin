package system.manager.ui;

import system.member.competitor.Discipline;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 This is the programs UI class. It is used as the link between user and program.
 */
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

    public int validateRange(int maxRange) {
        int choice = getInt("Please enter a number: ");

        while (choice < 0 || choice > maxRange) {
            displayLn("Out of range, try again");
            choice = getInt("Please enter a number: ");
        }

        return choice;
    }

    public char getChar(char a, char b) {
        char first = 0;
        char input;
        while (first == 0) {
            input = scanner.nextLine().charAt(0);
            first = validateChar(input, a, b);
        }
        return first;
    }

    private char validateChar(char input, char a, char b) {
        if (input == a || input == b) {
            return input;
        }
        displayLn("This is not what we are looking for. You have no powers here!");
        return 0;
    }

    public LocalDate getDate() {
        String birthDate = getString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateOfBirth = LocalDate.parse(birthDate, formatter);
        return dateOfBirth;
    }

    public Duration getTime() {
        display("Please enter time in miliseconds: ");
        int time = getInt("Please enter time in miliseconds");
        return Duration.ofMillis(time);
    }

    public Discipline getDiscipline() {
        int choice;

        do {
            choice = getInt("Whoopsie - I would like a number.");
            if (choice == 1) {
                return Discipline.BUTTERFLY;
            } else if (choice == 2) {
                return Discipline.CRAWL;
            } else if (choice == 3) {
                return Discipline.BACKCRAWL;
            } else if (choice == 4) {
                return Discipline.BREASTSTROKE;
            }
        } while (choice < 0 || choice > 5);
        return null;
    }
}
