package system;

import system.commands.FileHandler;
import system.commands.ShowMembers;
import system.member.Member;
import java.util.ArrayList;

// Michala
public class MemberManager {
    private FileHandler fileHandler = new FileHandler();
    private ArrayList<Member> members = fileHandler.loadFile();
    private ShowMembers showMembers = new ShowMembers(this);

    public ArrayList<Member> getMembers(){
        return members;
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }

    public ShowMembers getShowMembers() {
        this.members = fileHandler.loadFile();
        return showMembers;
    }
}
