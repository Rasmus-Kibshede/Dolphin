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
 * The FileHandler class is in charge of the different txt files which are used throughout the program to secure
 * data is saved and that the earlier saved data is used the next time the program is started.
 * <p>
 * The FileHandler has several sections of methods. Firstly it can load and save information about the club
 * "Delfinen".
 * Secondly it can do the same for members and Members subclass Competitor. This secures no loss in data even though
 * different types of members exist.
 * Thirdly it handles a file which stores information about earlier members whose membership have been shut own
 * because they repeatedly did not pay their bills to the club.
 * Besides all this it also supplies the program with membernumbers, so that every member gets a unique ID.
 */

public class FileHandler {
  private FileWriter fileWriter;
  private final ArrayList<Member> ALL_MEMBERS = new ArrayList<>();
  private int memberNumber;

  private final File MEMBERS_FILE = new File("Members.txt");
  private final File PEOPLE_IN_RKI_FILE = new File("PeopleInRKI.txt");
  private final File COMPETITORS_FILE = new File("Competitors.txt");
  private final File MEMBER_NUMBER_FILE = new File("MemberNumber");

  public void saveFile(ArrayList<Member> members) {
    try {
      ArrayList<Member> onlyMembers = new ArrayList<>();
      ArrayList<Competitor> onlyCompetitors = new ArrayList<>();

      boolean competitor;

      for (Member member : members) {
        competitor = checkMemberType(member);
        if (competitor) {
          onlyCompetitors.add((Competitor) member);
        } else {
          onlyMembers.add(member);
        }
      }

      fileWriter = new FileWriter(COMPETITORS_FILE);
      saveCompetitor(onlyCompetitors);
      fileWriter.close();

      fileWriter = new FileWriter(MEMBERS_FILE);
      saveMember(onlyMembers);
      fileWriter.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Member> loadFile() {
    try {
      ALL_MEMBERS.clear();

      loadMember();

      loadCompetitor();
    } catch (
        FileNotFoundException e) {
      e.printStackTrace();
    }
    return ALL_MEMBERS;
  }

  //----------------------------------------- RKI -------------------------------------

  public void saveRKI(ArrayList<Member> members) {
    try {

      fileWriter = new FileWriter(PEOPLE_IN_RKI_FILE);
      saveMember(members);
      fileWriter.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Member> loadRKI() {
    ArrayList<Member> membersInRKI = new ArrayList<>();
    try {
      Scanner fileReader = new Scanner(PEOPLE_IN_RKI_FILE);

      while (fileReader.hasNext()) {
        String memberName = fileReader.next();
        LocalDate dateOfBirth = LocalDate.parse(fileReader.next()); //Husk at sikre formattering.
        String email = fileReader.next();
        String phoneNumber = fileReader.next();
        boolean active = Boolean.parseBoolean(fileReader.next());
        boolean inDebt = Boolean.parseBoolean(fileReader.next());
        String payment = fileReader.next();
        int memberNumber = fileReader.nextInt();

        membersInRKI.add(new Member(memberName, dateOfBirth, email, phoneNumber, active, memberNumber));
      }
      fileReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return membersInRKI;
  }

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
              + member.isInDebt()
              + " "
              + member.getMembershipPrice()
              + " "
              + member.getMemberNumber()
              + "\n"
      );
    }
  }

  private void loadMember() throws FileNotFoundException {
    Scanner fileReaderMember = new Scanner(MEMBERS_FILE);

    while (fileReaderMember.hasNext()) {
      String memberName = fileReaderMember.next();
      LocalDate dateOfBirth = LocalDate.parse(fileReaderMember.next()); //Husk at sikre formattering.
      String email = fileReaderMember.next();
      String phoneNumber = fileReaderMember.next();
      boolean active = Boolean.parseBoolean(fileReaderMember.next());
      boolean inDebt = Boolean.parseBoolean(fileReaderMember.next());
      String payment = fileReaderMember.next();
      int memberNumber = fileReaderMember.nextInt();

      ALL_MEMBERS.add(new Member(memberName, dateOfBirth, email, phoneNumber, active, inDebt, memberNumber));
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
            .append(trainingScore.getDATE())
            .append(" ")
            .append(trainingScore.getTIME().toMillis())
            .append(" ")
            .append(trainingScore.getDISCIPLINE())
            .append(" ");
      }

      StringBuilder competitions = new StringBuilder();
      for (Competition competition : competitor.getCompetitions()) {
        competitions
            .append(competition.getCOMPETITION_NAME())
            .append(" ")
            .append(competition.getCOMPETITOR_PLACEMENT())
            .append(" ")
            .append(competition.getCOMPETITOR_TIME().toMillis())
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
              + competitor.isInDebt()
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
      LocalDate dateOfBirth = LocalDate.parse(fileReader.next());
      String email = fileReader.next();
      String phoneNumber = fileReader.next();
      boolean active = Boolean.parseBoolean(fileReader.next());
      boolean inDebt = Boolean.parseBoolean(fileReader.next());
      // We have to read payment from the file, but it is autogenerated for the individual competitor
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

      ArrayList<Discipline> disciplines = new ArrayList<>();

      while (fileReader.hasNext()) {
        String discipline = fileReader.next();

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
      ALL_MEMBERS.add(new Competitor(
          memberName,
          dateOfBirth,
          email,
          phoneNumber,
          active,
          inDebt,
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