package system.commands;

import system.MemberManager;
import system.member.Member;
import system.member.competition.Competitor;
import system.member.competition.TrainingScore;
import system.ui.UI;
import java.time.Duration;
import java.time.LocalDate;

public class RegisterTrainingScore implements Command {
    private MemberManager memberManager;

    public RegisterTrainingScore(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @Override
    public void execute(UI ui) {
        ui.display("Please enter date: ");
        LocalDate date = ui.getDate();
        ui.display("Please register time: ");
        Duration time = ui.getTime();
        TrainingScore trainingScore = new TrainingScore(date, time);
        for (Member member : memberManager.getMembers()) {
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
