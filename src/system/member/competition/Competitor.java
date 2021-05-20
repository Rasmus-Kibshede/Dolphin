package system.member.competition;

import system.member.Member;
import java.time.LocalDate;
import java.util.ArrayList;

public class Competitor extends Member {
    private ArrayList<Discipline> disciplines = new ArrayList<>();
    private TrainingScore trainingScore;

    public Competitor(String name, LocalDate dateOfBirth, String email, String phoneNumber, boolean active, int memberNumber, TrainingScore trainingScore, ArrayList<Discipline> disciplines) {
        super(name, dateOfBirth, email, phoneNumber, active, memberNumber);
        setTrainingScore(null);
        setDisciplines(disciplines);
    }

    public Competitor(String name, LocalDate dateOfBirth, String email, String phoneNumber, boolean active, int memberNumber, ArrayList<Discipline> disciplines) {
        super(name, dateOfBirth, email, phoneNumber, active, memberNumber);
        setDisciplines(disciplines);
    }

    public void setTrainingScore(TrainingScore trainingScore) {
        this.trainingScore = trainingScore;
    }

    public void setDisciplines(ArrayList<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public TrainingScore getTrainingScore() {
        return trainingScore;
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

}
