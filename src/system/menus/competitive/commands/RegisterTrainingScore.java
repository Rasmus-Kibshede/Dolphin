package system.menus.competitive.commands;

import system.manager.Manager;
import system.Command;
import system.member.Member;
import system.member.competitor.Competitor;
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
        ui.display("Please register time: ");
        Duration time = ui.getTime();
        TrainingScore trainingScore = new TrainingScore(date, time);
        for (Member member : manager.getMembers()) {
            if (member instanceof Competitor) {
                ((Competitor) member).setTrainingScore(trainingScore);
            }
        }
    }

    @Override
    public String getName() {
        return "Register Training Score";
    }
}
