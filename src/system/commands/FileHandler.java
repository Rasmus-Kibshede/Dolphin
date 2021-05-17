package system.commands;

import system.member.Member;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private final File MEMBER_FILE = new File("Members.txt");

    public void saveFile(ArrayList<Member> members) {
        try {
            FileWriter fileWriter = new FileWriter(MEMBER_FILE);
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
                                + "\n"
                );
                fileWriter.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Member> loadFile() {
        ArrayList<Member> members = new ArrayList<>();

        try {
            Scanner fileReader = new Scanner(MEMBER_FILE);
            while (fileReader.hasNext()) {
                String memberName = fileReader.next();
                LocalDate dateOfBirth = LocalDate.parse(fileReader.next()); //Husk at sikre formattering.
                String email = fileReader.next();
                String phoneNumber = fileReader.next();
                Boolean active = Boolean.parseBoolean(fileReader.next());
                String payment = fileReader.next();

                members.add(new Member(memberName, dateOfBirth, email, phoneNumber, active));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return members;
    }
}
