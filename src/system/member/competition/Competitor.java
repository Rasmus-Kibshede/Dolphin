package system.member.competition;

import system.member.Member;

import java.time.LocalDate;
import java.util.Collections;

public class Competitor extends Member {

    private TrainingScore trainingScore;

    public Competitor(String name, LocalDate dateOfBirth, String email, String phoneNumber, boolean active, int memberNumber, TrainingScore trainingScore) {
        super(name, dateOfBirth, email, phoneNumber, active, memberNumber);
        setTrainingScore(null);
    }

    public Competitor(String name, LocalDate dateOfBirth, String email, String phoneNumber, boolean active, int memberNumber) {
        super(name, dateOfBirth, email, phoneNumber, active, memberNumber);
    }

    public void setTrainingScore(TrainingScore trainingScore) {
        this.trainingScore = trainingScore;
    }

    public TrainingScore getTrainingScore() {
        return trainingScore;
    }
}
