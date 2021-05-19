package system.commands;

import system.member.Member;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// Michala
public class FileHandler {
  //private final File MEMBER_FILE = new File("Members.txt");
  //private final File MEMBERS_IN_RKI = new File("MembersInPKI.txt");

  public void saveFile(ArrayList<Member> members, File fileName) {
    try {
      FileWriter fileWriter = new FileWriter(fileName);
      for (int i = 0; i < members.size(); i++) {
        fileWriter.write(
            members.get(i).getName()
                + " "
                + members.get(i).getDateOfBirth()
                + " "
                + members.get(i).getEmail()
                + " "
                + members.get(i).getPhoneNumber()
                + " "
                + members.get(i).getActive()
                + " "
                + members.get(i).getMembershipPrice()
                + " "
                + members.get(i).getMemberNumber()
                + "\n"
        );
      }
      fileWriter.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Member> loadFile(File filename) {
    ArrayList<Member> members = new ArrayList<>();

    try {
      Scanner fileReader = new Scanner(filename);
      while (fileReader.hasNext()) {
        String memberName = fileReader.next();
        LocalDate dateOfBirth = LocalDate.parse(fileReader.next()); //Husk at sikre formattering.
        String email = fileReader.next();
        String phoneNumber = fileReader.next();
        Boolean active = Boolean.parseBoolean(fileReader.next());
        String payment = fileReader.next();
        int memberNumber = fileReader.nextInt();

        members.add(new Member(memberName, dateOfBirth, email, phoneNumber, active, memberNumber));
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return members;
  }

  public int loadMemberNumber(File filename) {

    int memberNumber = 0;
    try {
      Scanner fileReader = new Scanner(filename);

      memberNumber = Integer.parseInt(fileReader.next());

    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());

      //TODO throw here
    }

    //TODO Not correct!!! Throw exception if there is no file, instead sending a number back
    return memberNumber;

  }

  public void saveMemberNumber(File filename, int memberNumber) {

    try {
      FileWriter fileWriter = new FileWriter(filename);

      memberNumber++;

      fileWriter.append(String.valueOf(memberNumber));
      fileWriter.close();

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

}
