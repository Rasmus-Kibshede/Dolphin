package system.member.competitor;

import system.member.Member;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Competitor extends Member {
    // Maybe this should be a normal Array, since they can only participate in four disciplines?
    private ArrayList<Discipline> disciplines = new ArrayList<>();
    private TrainingScore trainingScore = setTrainingToDefault();

    public Competitor(String name, LocalDate dateOfBirth, String email, String phoneNumber, boolean active, int memberNumber, TrainingScore trainingScore, ArrayList<Discipline> disciplines) {
        super(name, dateOfBirth, email, phoneNumber, active, memberNumber);
        setTrainingScore(setTrainingToDefault());
        setDisciplines(disciplines);
    }

    public TrainingScore setTrainingToDefault(){
        String date = "12-12-1200";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate d = LocalDate.parse(date, dateTimeFormatter);

        Duration time = Duration.ofMillis(0);
        return new TrainingScore(d, time);
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
