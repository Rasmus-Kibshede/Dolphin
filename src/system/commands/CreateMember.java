package system.commands;

import system.MemberManager;
import system.member.Member;
import system.ui.UI;
import java.time.LocalDate;

//Kamille
public class CreateMember implements Command {
    private MemberManager memberManager;

    public CreateMember(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @Override
    public void execute(UI ui) {
        ui.displayLn("Enter member name: ");
        String memberName = ui.getString();
        ui.displayLn("Enter members date of birth: ");
        LocalDate dateOfBirth = ui.getDate();
        ui.displayLn("Enter members email: ");
        String email = ui.getString();
        ui.displayLn("Enter members phone number: ");
        String phoneNumber = ui.getString();
        ui.displayLn("Enter A for active and P for passive");
        boolean active = setActive(Character.toLowerCase(ui.getChar()));

        memberManager.getMembers().add(new Member(memberName, dateOfBirth, email, phoneNumber, active));

        //Update file
    }

    @Override
    public String getName() {
        return "Create Member";
    }

    public Boolean setActive(Character c){
        if (c == 'p') {
            return false;
        }
        return true;
    }
}
