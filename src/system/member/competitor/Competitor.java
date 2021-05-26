package system.member.competitor;

import system.member.Member;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 This class (subclass to Member) is a type of member in "Delfinen" club. A Comeptitor can have different
 disciplines, trainingscores pr. discipline and competitions connected to them.
 */
public class Competitor extends Member {

    private ArrayList<Discipline> disciplines = new ArrayList<>();
    private ArrayList<TrainingScore> trainingScores = new ArrayList<>();
    private ArrayList<Competition> competitions = new ArrayList<>();

    public Competitor(String name,
                      LocalDate dateOfBirth,
                      String email,
                      String phoneNumber,
                      boolean active,
                      boolean inDebt,
                      int memberNumber,
                      ArrayList<TrainingScore> trainingScores,
                      ArrayList<Discipline> disciplines,
                      ArrayList<Competition> competitions
    ) {
        super(name, dateOfBirth, email, phoneNumber, active, inDebt, memberNumber);
        setTrainingScores(trainingScores);
        setDisciplines(disciplines);
        setCompetitions(competitions);
    }

    public Competitor(String name,
                      LocalDate dateOfBirth,
                      String email,
                      String phoneNumber,
                      boolean active,
                      boolean inDebt,
                      int memberNumber,
                      ArrayList<Discipline> disciplines
    ) {
        super(name, dateOfBirth, email, phoneNumber, active, inDebt, memberNumber);
        setDisciplines(disciplines);
    }

    public void setTrainingScores(ArrayList<TrainingScore> trainingScores) {
        this.trainingScores = trainingScores;
    }

    public void setDisciplines(ArrayList<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public void setCompetitions(ArrayList<Competition> competitions) {
        this.competitions = competitions;
    }

    public ArrayList<TrainingScore> getTrainingScores() {
        return trainingScores;
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public ArrayList<Competition> getCompetitions() {
        return competitions;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public LocalDate getDateOfBirth() {
        return super.getDateOfBirth();
    }

    @Override
    public String toString() {
        return super.toString() +
                "TrainingScores: "
                + trainingScores
                + "\nDisciplines: "
                + disciplines
                + "\nCompetitions: "
                + competitions
                ;
    }
}
