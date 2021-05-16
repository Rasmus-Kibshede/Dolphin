package system.commands;

import system.MemberManager;
import system.member.Member;
import system.ui.UI;

import java.time.LocalDate;

public class CreateMember implements Command {
    private String name;
    private MemberManager memberManager;

    public CreateMember(MemberManager memberManager) {
        String memberName = null;
        LocalDate dateOfBirth = null;
        String email = null;
        String phoneNumber = null;
        boolean active;
        double memberShipPrice = 0;

        memberManager.getMembers().add(new Member(memberName, dateOfBirth, email, phoneNumber, active, memberShipPrice));
    }

    @Override
    public void execute(UI ui) {
        ui.display("Enter member name: ");
        ui.getString();
        ui.display("Enter members date of birth: ");
        ui.getDate();
        ui.display("Enter members email: ");
        ui.getString();
        ui.display("Enter members phone number: ");
        ui.getString();

    }

    @Override
    public String getName() {
        return null;
    }
}
