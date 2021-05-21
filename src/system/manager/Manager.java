package system.manager;

import system.member.competitor.Competitor;
import system.menus.member.commands.ShowMembers;
import system.member.Member;
import system.member.competitor.Discipline;
import system.member.competitor.Team;

import java.time.LocalDate;
import java.time.Period;
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
        teams[0] = new Team("Stinna", "Junior Crawl", Discipline.CRAWL);
        teams[1] = new Team("Benjamin", "Junior Back Crawl", Discipline.BACKCRAWL);
        teams[2] = new Team("Benjamin", "Junior Butterfly", Discipline.BUTTERFLY);
        teams[3] = new Team("Stinna", "Junior Breaststroke", Discipline.BREASTSTROKE);
        teams[4] = new Team("Babette", "Senior Crawl", Discipline.CRAWL);
        teams[5] = new Team("Tim", "Senior Back Crawl", Discipline.BACKCRAWL);
        teams[6] = new Team("Babette", "Senior Butterfly", Discipline.BUTTERFLY);
        teams[7] = new Team("Jim", "Senior Breaststroke", Discipline.BREASTSTROKE);
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Member> getMembersInRKI() {
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

    public String getDisciplines() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < disciplines.length; i++) {
            stringBuilder.append(((i) + 1)).append(". ").append(disciplines[i]).append("\n");

        }
        return stringBuilder.toString();
    }

    public void addToTeam(Competitor competitor) {
        for (int i = 0; i < competitor.getDisciplines().size(); i++) {
            Discipline discipline = competitor.getDisciplines().get(i);
            LocalDate dateOfBirth = competitor.getDateOfBirth();
            int age = Period.between(dateOfBirth, LocalDate.now()).getYears();

            if (discipline == Discipline.CRAWL) {
                if (age >= 18) {
                    teams[4].getCompetitors().add(competitor);
                }
                teams[0].getCompetitors().add(competitor);
            } else if (discipline == Discipline.BACKCRAWL) {
                if (age >= 18) {
                    teams[5].getCompetitors().add(competitor);
                }
                teams[1].getCompetitors().add(competitor);
            } else if (discipline == Discipline.BUTTERFLY) {
                if (age >= 18) {
                    teams[6].getCompetitors().add(competitor);
                }
                teams[2].getCompetitors().add(competitor);
            } else if (discipline == Discipline.BREASTSTROKE) {
                if (age >= 18) {
                    teams[7].getCompetitors().add(competitor);
                }
                teams[3].getCompetitors().add(competitor);
            }
        }
    }

    public void removeFromTeam(Competitor competitor, Discipline discipline) {
        for (int i = 0; i < competitor.getDisciplines().size(); i++) {
            LocalDate dateOfBirth = competitor.getDateOfBirth();
            int age = Period.between(dateOfBirth, LocalDate.now()).getYears();

            if (discipline == Discipline.CRAWL) {
                if (age >= 18) {
                    teams[4].getCompetitors().remove(competitor);
                }
                teams[0].getCompetitors().remove(competitor);
            } else if (discipline == Discipline.BACKCRAWL) {
                if (age >= 18) {
                    teams[5].getCompetitors().remove(competitor);
                }
                teams[1].getCompetitors().remove(competitor);
            } else if (discipline == Discipline.BUTTERFLY) {
                if (age >= 18) {
                    teams[6].getCompetitors().remove(competitor);
                }
                teams[2].getCompetitors().remove(competitor);
            } else if (discipline == Discipline.BREASTSTROKE) {
                if (age >= 18) {
                    teams[7].getCompetitors().remove(competitor);
                }
                teams[3].getCompetitors().remove(competitor);
            }
        }

    }
}
