package system.manager;

import system.menus.member.commands.ShowMembers;
import system.member.Member;
import system.member.competitor.Discipline;
import system.member.competitor.Team;
import java.util.ArrayList;

public class Manager {
    private FileHandler fileHandler = new FileHandler();
    private ArrayList<Member> members = fileHandler.loadFile();
    private ArrayList<Member> membersInRKI = fileHandler.loadToRKI();
    private ShowMembers showMembers = new ShowMembers(this);
    private Team[] teams;
    private Discipline[] disciplines = Discipline.values();

    public Manager() {
        teams = new Team[8];
        teams[0] = new Team("Stinna", "Junior Crawl", Discipline.Crawl);
        teams[1] = new Team("Benjamin", "Junior Back Crawl", Discipline.Backcrawl);
        teams[2] = new Team("Benjamin", "Junior Butterfly", Discipline.Butterfly);
        teams[3] = new Team("Stinna", "Junior Breaststroke", Discipline.Breaststroke);
        teams[4] = new Team("Babette", "Senior Crawl", Discipline.Crawl);
        teams[5] = new Team("Tim", "Senior Back Crawl", Discipline.Backcrawl);
        teams[6] = new Team("Babette", "Senior Butterfly", Discipline.Butterfly);
        teams[7] = new Team("Jim", "Senior Breaststroke", Discipline.Breaststroke);
    }

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

    public Team[] getTeams() {
        return teams;
    }

    public String getDisciplines(){
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < disciplines.length; i++){
            stringBuilder.append(((i) + 1)).append(disciplines[i]);
        }

        return stringBuilder.toString();
    }

}
