package system.manager;

import system.member.Member;
import system.member.competitor.Competition;
import system.member.competitor.Competitor;
import system.member.competitor.Discipline;
import system.member.competitor.TrainingScore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 The FileHandler class is in charge of the different txt files which are used throughout the program to secure
 data is saved and that the earlier saved data is used the next time the program is started.

 The FileHandler has several sections of methods. Firstly it can load and save information about the club
 "Delfinen".
 Secondly it can do the same for members and Members subclass Competitor. This secures no loss in data even though
 different types of members exist.
 Thirdly it handles a file which stores information about earlier members whose membership have been shut own
 because they repeatedly did not pay their bills to the club.
 Besides all this it also supplies the program with membernumbers, so that every member gets a unique ID.
 */

public class FileHandler {
    private FileWriter fileWriter;

    private final File MEMBER_FILE = new File("Members.txt");
    private final File MEMBERS_IN_RKI_FILE = new File("MembersInRKI.txt");
    private final File COMPETITORS_FILE = new File("Competitors.txt");
    private final File MEMBER_NUMBER_FILE = new File("MemberNumber");

    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Discipline> disciplines = new ArrayList<>();
    private int memberNumber;

    public void saveFile(ArrayList<Member> members) {
        try {
            ArrayList<Member> members1 = new ArrayList<>();
            ArrayList<Competitor> competitors = new ArrayList<>();

            boolean competitor;

            for (Member member : members) {
                competitor = checkMemberType(member);
                if (competitor) {
                    competitors.add((Competitor) member);
                } else {
                    members1.add(member);
                }
            }

            fileWriter = new FileWriter(COMPETITORS_FILE);
            saveCompetitor(competitors);
            fileWriter.close();

            fileWriter = new FileWriter(MEMBER_FILE);
            saveMember(members1);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Member> loadFile() {
        try {
            members.clear();

            loadMember();

            loadCompetitor();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        return members;
    }

    //----------------------------------------- RKI -------------------------------------

    public void saveToRKI(ArrayList<Member> members) {
        try {

            fileWriter = new FileWriter(MEMBERS_IN_RKI_FILE);
            saveMember(members);

        } catch (IOException e) {
            e.printStackTrace();
        }
    } //saveRKI???

    public ArrayList<Member> loadToRKI() {
        ArrayList<Member> membersInRKI = new ArrayList<>();
        try {
            Scanner fileReader = new Scanner(MEMBERS_IN_RKI_FILE);

            while (fileReader.hasNext()) {
                String memberName = fileReader.next();
                LocalDate dateOfBirth = LocalDate.parse(fileReader.next()); //Husk at sikre formattering.
                String email = fileReader.next();
                String phoneNumber = fileReader.next();
                Boolean active = Boolean.parseBoolean(fileReader.next());
                String payment = fileReader.next();
                int memberNumber = fileReader.nextInt();

                membersInRKI.add(new Member(memberName, dateOfBirth, email, phoneNumber, active, memberNumber));
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return membersInRKI;
    } //loadRKI??

    //----------------------------------------- Member -------------------------------------

    private void saveMember(ArrayList<Member> members) throws IOException {
        for (Member member : members) {
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
    }

    private void loadMember() throws FileNotFoundException {
        Scanner fileReaderMember = new Scanner(MEMBER_FILE);

        while (fileReaderMember.hasNext()) {
            String memberName = fileReaderMember.next();
            LocalDate dateOfBirth = LocalDate.parse(fileReaderMember.next()); //Husk at sikre formattering.
            String email = fileReaderMember.next();
            String phoneNumber = fileReaderMember.next();
            Boolean active = Boolean.parseBoolean(fileReaderMember.next());
            String payment = fileReaderMember.next();
            int memberNumber = fileReaderMember.nextInt();

            members.add(new Member(memberName, dateOfBirth, email, phoneNumber, active, memberNumber));
        }
        fileReaderMember.close();
    }

    //----------------------------------------- Competitor -------------------------------------

    private void saveCompetitor(ArrayList<Competitor> competitors) throws IOException {

        for (Competitor competitor : competitors) {
            StringBuilder disciplines = new StringBuilder();
            for (int i = 0; i < competitor.getDisciplines().size(); i++) {
                disciplines.append(competitor.getDisciplines().get(i)).append(" ");
            }

            StringBuilder trainingScores = new StringBuilder();
            for (TrainingScore trainingScore : competitor.getTrainingScores()) {
                trainingScores
                        .append(trainingScore.getDate())
                        .append(" ")
                        .append(trainingScore.getTime().toMillis())
                        .append(" ")
                        .append(trainingScore.getDiscipline())
                        .append(" ");
            }

            StringBuilder competitions = new StringBuilder();
            for (Competition competition : competitor.getCompetitions()) {
                competitions
                        .append(competition.getCompetitionName())
                        .append(" ")
                        .append(competition.getCompetitorPlacement())
                        .append(" ")
                        .append(competition.getCompetitorTime().toMillis())
                        .append(" ");
            }

            fileWriter.write(
                    competitor.getName()
                            + " "
                            + competitor.getDateOfBirth()
                            + " "
                            + competitor.getEmail()
                            + " "
                            + competitor.getPhoneNumber()
                            + " "
                            + competitor.getActive()
                            + " "
                            + competitor.getMembershipPrice()
                            + " "
                            + competitor.getMemberNumber()
                            + " "
                            + trainingScores
                            + ". "
                            + disciplines
                            + ". "
                            + competitions
                            + ".\n"

            );
        }
    }

    private void loadCompetitor() throws FileNotFoundException {
        Scanner fileReader = new Scanner(COMPETITORS_FILE);

        while (fileReader.hasNext()) {

            String memberName = fileReader.next();
            LocalDate dateOfBirth = LocalDate.parse(fileReader.next()); //Husk at sikre formattering.
            String email = fileReader.next();
            String phoneNumber = fileReader.next();
            Boolean active = Boolean.parseBoolean(fileReader.next());
            String payment = fileReader.next();
            int memberNumber = fileReader.nextInt();


            ArrayList<TrainingScore> trainingScores = new ArrayList<>();
            while (fileReader.hasNext()) {
                String check = fileReader.next();
                if (check.equals(".")) {
                    break;
                }
                LocalDate date = LocalDate.parse(check);
                Duration time = Duration.ofMillis(fileReader.nextInt());
                Discipline discipline = Discipline.valueOf(fileReader.next());

                TrainingScore trainingScore = new TrainingScore(date, time, discipline);
                trainingScores.add(trainingScore);
            }

            disciplines.clear();
            while (fileReader.hasNext()) {
                String discipline = fileReader.next();
                //Quick fix - without "if" it will read everything in the file.
                if (discipline.equals(".")) {
                    break;
                } else {
                    disciplines.add(Discipline.valueOf(discipline));
                }
            }

            ArrayList<Competition> competitions = new ArrayList<>();
            while (fileReader.hasNext()) {
                String check = fileReader.next();
                if (check.equals(".")) {
                    break;
                }
                String competitionName = check;
                int placement = fileReader.nextInt();
                Duration time = Duration.ofMillis(fileReader.nextInt());

                Competition competition = new Competition(competitionName, placement, time);
                competitions.add(competition);
            }
            members.add(new Competitor(
                    memberName,
                    dateOfBirth,
                    email,
                    phoneNumber,
                    active,
                    memberNumber,
                    trainingScores,
                    disciplines,
                    competitions
            ));
        }
        fileReader.close();
    }

    //----------------------------------------- Member number -------------------------------------

    public void saveMemberNumber() {
        try {
            memberNumber++;

            FileWriter fileWriter = new FileWriter(MEMBER_NUMBER_FILE);

            fileWriter.append(String.valueOf(memberNumber));
            fileWriter.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int loadMemberNumber() {

        memberNumber = 0;
        try {
            Scanner fileReader = new Scanner(MEMBER_NUMBER_FILE);

            memberNumber = Integer.parseInt(fileReader.next());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

            //TODO throw here
        }

        //TODO Not correct!!! Throw exception if there is no file, instead sending a number back
        return memberNumber;
    }

    //----------------------------------------- Member type check -------------------------------------

    private boolean checkMemberType(Member member) {
        if (member instanceof Competitor) {
            return true;
        }
        return false;
    }
}