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

    }

    @Override
    public String getName() {
        return null;
    }
}
