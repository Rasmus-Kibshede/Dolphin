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

public class RegisterTrainingScore implements Command {
    private Manager manager;

    public RegisterTrainingScore(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(UI ui) {
        ui.display("Please enter date: ");
        LocalDate date = ui.getDate();
        Duration time = ui.getTime();

        ui.displayLn(manager.getDisciplines());
        ui.display("Please enter discipline: ");
        Discipline discipline = ui.getDiscipline();

        TrainingScore trainingScore = new TrainingScore(date, time, discipline);

        ui.display("Please enter member number for competitor: ");
        int memberNumber = ui.getInt("This is not a number.");

        for (Member member : manager.getMembers()) {
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
        manager.getFileHandler().saveFile(manager.getMembers());
    }

    private boolean checkIfBetter(TrainingScore trainingScoreOne, TrainingScore trainingScoreTwo) {
        if (trainingScoreOne.getDiscipline() == trainingScoreTwo.getDiscipline()) {
            long originalTime = trainingScoreOne.getTime().toMillis();
            if (originalTime == 0) {
                return true;
            }

            long newTime = trainingScoreTwo.getTime().toMillis();
            return originalTime > newTime;
        }
        return false;
    }

    private TrainingScore getTrainingScore(Competitor competitor, TrainingScore trainingScore) {
        for (int i = 0; i < competitor.getTrainingScores().size(); i++) {
            if (competitor.getTrainingScores().get(i).getDiscipline() == trainingScore.getDiscipline()) {
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
