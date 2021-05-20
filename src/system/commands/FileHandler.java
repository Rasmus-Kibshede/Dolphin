package system.commands;

import system.member.Member;
import system.member.competition.Competitor;
import system.member.competition.TrainingScore;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private FileWriter fileWriter;

    public void saveFile(ArrayList<Member> members, File memberFile, File competitorFile) {
        try {
            boolean competitor;
            for (int i = 0; i < members.size(); i++) {
                competitor = checkMemberType(members.get(i));
                if (competitor) {
                    fileWriter = new FileWriter(competitorFile);
                    saveCompetitor((Competitor) members.get(i));
                }
                fileWriter = new FileWriter(memberFile);
                saveMember(members.get(i));
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Member> loadFile(File memberFile, File competitorFile) {
        ArrayList<Member> members = new ArrayList<>();
        try {
            ArrayList<Member> firstMemberList = loadMember(memberFile);
            ArrayList<Member> secondMemberList = loadCompetitor(competitorFile);

            firstMemberList.addAll(secondMemberList);
            members = firstMemberList;
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        return members;
    }

    public void saveMember(Member member) throws IOException {
        fileWriter.write(
                member.getName()
                        + " "
                        + member.getDateOfBirth()
                        + " "
                        + member.getEmail()
                        + " "
                        + member.getPhoneNumber()
                        + " "
                        + member.getActive()
                        + " "
                        + member.getMembershipPrice()
                        + " "
                        + member.getMemberNumber()
                        + "\n"
        );
    }

    public void saveCompetitor(Competitor member) throws IOException {
        fileWriter.write(
                member.getName()
                        + " "
                        + member.getDateOfBirth()
                        + " "
                        + member.getEmail()
                        + " "
                        + member.getPhoneNumber()
                        + " "
                        + member.getActive()
                        + " "
                        + member.getMembershipPrice()
                        + " "
                        + member.getMemberNumber()
                        + " "
                        + member.getTrainingScore()
                        + "\n"
        );
    }

    public ArrayList<Member> loadMember(File memberFile) throws FileNotFoundException {
        ArrayList<Member> members = new ArrayList<Member>();
        Scanner fileReader = new Scanner(memberFile);

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
        return members;
    }

    public ArrayList<Member> loadCompetitor(File competitorFile) throws FileNotFoundException {
        ArrayList<Member> members = new ArrayList<>();
        Scanner fileReader = new Scanner(competitorFile);

        while (fileReader.hasNext()) {
            String memberName = fileReader.next();
            LocalDate dateOfBirth = LocalDate.parse(fileReader.next()); //Husk at sikre formattering.
            String email = fileReader.next();
            String phoneNumber = fileReader.next();
            Boolean active = Boolean.parseBoolean(fileReader.next());
            String payment = fileReader.next();
            int memberNumber = fileReader.nextInt();
            LocalDate date = LocalDate.parse(fileReader.next());
            LocalTime time = LocalTime.parse(fileReader.next());
            TrainingScore trainingScore = new TrainingScore(date, time);

            members.add(new Competitor(memberName, dateOfBirth, email, phoneNumber, active, memberNumber, trainingScore));
        }
        return members;
    }

    public boolean checkMemberType(Member member) {
        if (member instanceof Competitor) {
            return true;
        }
        return false;
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
