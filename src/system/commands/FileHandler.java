package system.commands;

import system.member.Member;
import system.ui.UI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler implements Command {
    private final File MEMBER_FILE = new File("Members.txt");

    public void saveFile(ArrayList<Member> members) {
        try {
            FileWriter fileWriter = new FileWriter(MEMBER_FILE);
            for (int i = 0; i < members.size(); i++) {
                fileWriter.write(
                        members.get(i).getName() +
                );
            }

        } catch (IOException e) {
        }
        try {

        }

    } catch(
    FileNotFoundException e)

    {
        e.printStackTrace();
    }

    public void loadFile() {
        try {
            Scanner fileReader = new Scanner(MEMBER_FILE);
            while (fileReader.hasNextLine()) {
                String memberName = fileReader.next();
                LocalDate dateOfBirth = LocalDate.parse(fileReader.next()); //Husk at sikre formattering.
                String email = fileReader.next();
                String phoneNumber = fileReader.next();
                Boolean active = Boolean.parseBoolean(fileReader.next());
            }
            Member member = new Member();
        } catch (IOException e) {

        }
    }

    @Override
    public void execute(UI ui) {

    }

    @Override
    public String getName() {
        return "File Handling";
    }
}
