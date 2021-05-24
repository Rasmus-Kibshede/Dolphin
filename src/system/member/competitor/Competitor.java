package system.member.competitor;

import system.member.Member;
import java.time.LocalDate;
import java.util.ArrayList;

public class Competitor extends Member {
    // Maybe this should be a normal Array, since they can only participate in four disciplines?
    private ArrayList<Discipline> disciplines = new ArrayList<>();
    private ArrayList<TrainingScore> trainingScores = new ArrayList<>();

    public Competitor(String name, LocalDate dateOfBirth, String email, String phoneNumber, boolean active, int memberNumber, ArrayList<TrainingScore> trainingScores, ArrayList<Discipline> disciplines) {
        super(name, dateOfBirth, email, phoneNumber, active, memberNumber);
        setTrainingScores(trainingScores);
        setDisciplines(disciplines);
    }

    public Competitor(String name, LocalDate dateOfBirth, String email, String phoneNumber, boolean active, int memberNumber, ArrayList<Discipline> disciplines) {
        super(name, dateOfBirth, email, phoneNumber, active, memberNumber);
        setDisciplines(disciplines);
    }

    public void setTrainingScores(ArrayList<TrainingScore> trainingScores) {
        this.trainingScores = trainingScores;
    }

    public void setDisciplines(ArrayList<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public ArrayList<TrainingScore> getTrainingScores() {
        return trainingScores;
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
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
                + ". Disciplines: "
                + disciplines
                ;
    }
}
