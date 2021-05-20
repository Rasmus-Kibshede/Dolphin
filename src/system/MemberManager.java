package system;

import system.commands.FileHandler;
import system.commands.ShowMembers;
import system.member.Member;
import java.util.ArrayList;

public class MemberManager {
    private FileHandler fileHandler = new FileHandler();
    private ArrayList<Member> members = fileHandler.loadFile();
    private ArrayList<Member> membersInRKI = fileHandler.loadToRKI();
    private ShowMembers showMembers = new ShowMembers(this);

    public ArrayList<Member> getMembers(){
        return members;
    }

    public ArrayList<Member> getMembersInRKI(){
        return membersInRKI;
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }

    public ShowMembers getShowMembers() {
        this.members = fileHandler.loadFile();
        return showMembers;
    }
}
