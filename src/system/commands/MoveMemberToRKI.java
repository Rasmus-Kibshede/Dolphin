package system.commands;

import system.MemberManager;
import system.ui.UI;

//Kamille
public class MoveMemberToRKI implements Command{

  private MemberManager memberManager;

  public MoveMemberToRKI(MemberManager memberManager){
    this.memberManager = memberManager;
  }


  @Override
  public void execute(UI ui) {
    memberManager.getShowMembers().execute(ui);

    ui.displayLn("Which member is to be moved to RKI? Please enter Member number:");
    int memberNumber = ui.getInt("Please enter an existing member number");

    for(int i = 0; i < memberManager.getMembers().size(); i++){
      if(memberNumber == memberManager.getMembers().get(i).getMemberNumber()){
        memberManager.getMembersInRKI().add(memberManager.getMembers().get(i));
        memberManager.getMembers().remove(memberManager.getMembers().get(i));
      }
    }
    memberManager.getFileHandler().saveFile(memberManager.getMembersInRKI(), memberManager.getMEMBERS_IN_RKI_FILE());

  }

  @Override
  public String getName() {
    return "Move Member To RKI";
  }
}
