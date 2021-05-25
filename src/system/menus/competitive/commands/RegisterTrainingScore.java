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
    //SKal være final
    private Manager manager;

    public RegisterTrainingScore(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(UI ui) {

        //Brug metode istedet for de næste 3 linjer
        manager.getShowCompetitors().execute(ui);
        ui.display("\nEnter Member Number of the Competitor whose training score you want to register: ");
        int memberNumber = ui.getInt();

        ui.display("\nPlease enter date dd-mm-yyyy: ");
        LocalDate date = ui.getDate();
        Duration time = ui.getTime();

        showCompetitorsDisciplines(memberNumber, ui);

        ui.display("Please choose a discipline: ");
        //Det er ikke den rigtige disciplin der bliver valgt...
        Discipline discipline = ui.getDiscipline();

        TrainingScore trainingScore = new TrainingScore(date, time, discipline);

        addTrainingScore(memberNumber, trainingScore, ui);

        manager.getFileHandler().saveFile(manager.getMembers());
    }

    private void addTrainingScore(int memberNumber, TrainingScore trainingScore, UI ui){
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
    }

    private void showCompetitorsDisciplines(int memberNumber, UI ui){
        for(Member m : manager.getMembers()){
            if(m instanceof Competitor && m.getMemberNumber() == memberNumber){
                ArrayList<Discipline> disciplines = ((Competitor) m).getDisciplines();
                for(int i = 0; i < disciplines.size(); i++){
                    ui.displayLn(((i) + 1) + ". " + disciplines.get(i).toString().replaceAll("\\[","").
                        replaceAll("]",""));
                }
            }
        }
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
