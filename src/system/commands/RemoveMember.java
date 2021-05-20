package system.commands;

import system.CompetitorManager;
import system.MemberManager;
import system.ui.UI;

//Michala
public class RemoveMember implements Command {
    private MemberManager memberManager;
    private CompetitorManager competitorManager;

    public RemoveMember(MemberManager memberManager, CompetitorManager competitorManager) {
        this.memberManager = memberManager;
        this.competitorManager = competitorManager;
    }

    @Override
    public void execute(UI ui) {
        memberManager.getShowMembers().execute(ui); //Skal måske flyttes ned mellem removing member og which member?
        ui.displayLn("Removing Member");
        ui.display("Which member is to be removed? Please enter Membernumber:");
        int memberNumber = ui.getInt("Please enter an existing member number");

        //Vi skal have smidt et loop ind

        for (int i = 0; i < memberManager.getMembers().size(); i++) {
            if (memberNumber == memberManager.getMembers().get(i).getMemberNumber()) {
                memberManager.getMembers().remove(memberManager.getMembers().get(i));
            }
        }
        memberManager.getFileHandler().saveFile(memberManager.getMembers(), memberManager.getMEMBER_FILE(), competitorManager.getCOMPETITORS_FILE());
    }

    @Override
    public String getName() {
        return "Remove Member";
    }
}
