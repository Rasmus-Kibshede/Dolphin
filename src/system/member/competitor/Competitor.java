package system.member.competitor;

import system.member.Member;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class Competitor extends Member {
    private ArrayList<Discipline> disciplines = new ArrayList<>();
    private TrainingScore trainingScore;

    public Competitor(String name, LocalDate dateOfBirth, String email, String phoneNumber, boolean active, int memberNumber, TrainingScore trainingScore, ArrayList<Discipline> disciplines) {
        super(name, dateOfBirth, email, phoneNumber, active, memberNumber);
        setTrainingScore(setTrainingToDefault());
        setDisciplines(disciplines);
    }

    public TrainingScore setTrainingToDefault(){
        LocalDate date = LocalDate.parse("1200-12-12");
        Duration time = Duration.ofMillis(0);
        return trainingScore = new TrainingScore(date, time);
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
                "TrainingScore: "
                + trainingScore
                + ". Disciplines: "
                + disciplines
                ;
    }
}
