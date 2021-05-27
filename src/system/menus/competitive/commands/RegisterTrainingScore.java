package system.menus.competitive.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.member.competitor.Competitor;
import system.member.competitor.Discipline;
import system.member.competitor.TrainingScore;
import system.manager.ui.UI;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class RegisterTrainingScore implements Command {
    private final Manager MANAGER;

    public RegisterTrainingScore(Manager manager) {
        this.MANAGER = manager;
    }

    @Override
    public void execute(UI ui) {
        MANAGER.getShowCompetitors().execute(ui);

        int memberNumber = MANAGER.getMenuNumber("\nEnter Member Number of the Competitor whose training score you want to register: ", ui);

        ui.display("\nPlease enter date dd-mm-yyyy: ");
        LocalDate date = ui.getDate();
        Duration time = ui.getTime();

        ui.display("Please choose a discipline: ");
        ui.displayLn(MANAGER.getDisciplines());
        Discipline discipline = ui.getDiscipline();

        TrainingScore trainingScore = new TrainingScore(date, time, discipline);

        addTrainingScore(memberNumber, trainingScore, ui);

        MANAGER.getFileHandler().saveFile(MANAGER.getMembers());
    }

    private void addTrainingScore(int memberNumber, TrainingScore trainingScore, UI ui){
        for (Member member : MANAGER.getMembers()) {
            if (memberNumber == member.getMemberNumber()) {
                if (member instanceof Competitor) {
                    TrainingScore checkExistence = getTrainingScore((Competitor) member, trainingScore);

                    if (checkExistence != null) {
                        boolean checkIfBetter = checkIfBetter(checkExistence, trainingScore);

                        if (checkIfBetter) {
                            ((Competitor) member).getTrainingScores().remove(checkExistence);
                            ((Competitor) member).getTrainingScores().add(trainingScore);
                        }
                        ui.displayLn("New Score is not better than existing score.");
                        return;
                    } else {
                        ((Competitor) member).getTrainingScores().add(trainingScore);
                    }
                } else {
                    ui.display("The member number you entered does not match a competitor.");
                }
            }
        }
    }

    private boolean checkIfBetter(TrainingScore trainingScoreOne, TrainingScore trainingScoreTwo) {
        if (trainingScoreOne.getDISCIPLINE() == trainingScoreTwo.getDISCIPLINE()) {
            long originalTime = trainingScoreOne.getTIME().toMillis();

            if (originalTime == 0) {
                return true;
            }

            long newTime = trainingScoreTwo.getTIME().toMillis();
            return originalTime > newTime;
        }
        return false;
    }

    private TrainingScore getTrainingScore(Competitor competitor, TrainingScore trainingScore) {
        for (int i = 0; i < competitor.getTrainingScores().size(); i++) {
            if (competitor.getTrainingScores().get(i).getDISCIPLINE() == trainingScore.getDISCIPLINE()) {
                return competitor.getTrainingScores().get(i);
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return "Register Training Score";
    }
}
