package system;

import system.commands.FileHandler;
import system.commands.ShowMembers;
import system.member.Member;
import java.io.File;
import java.util.ArrayList;

// Michala
public class MemberManager {
    private final File MEMBER_FILE = new File("Members.txt");
    private final File MEMBERS_IN_RKI_FILE = new File("MembersInRKI.txt");
    private FileHandler fileHandler = new FileHandler();
    private ArrayList<Member> members = fileHandler.loadFile(MEMBER_FILE);
    private ArrayList<Member> membersInRKI = fileHandler.loadFile(MEMBERS_IN_RKI_FILE);
    private ShowMembers showMembers = new ShowMembers(this);

    public File getMEMBER_FILE(){return MEMBER_FILE;}

    public File getMEMBERS_IN_RKI_FILE(){return MEMBERS_IN_RKI_FILE;}

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
        this.members = fileHandler.loadFile(MEMBER_FILE);
        return showMembers;
    }
}
