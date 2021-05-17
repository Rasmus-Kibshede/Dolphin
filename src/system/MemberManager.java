package system;

import system.commands.FileHandler;
import system.member.Member;
import java.util.ArrayList;

public class MemberManager {
    private ArrayList<Member> members;
    private FileHandler fileHandler = new FileHandler();

    public ArrayList<Member> getMembers(){
        return members;
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }
}
