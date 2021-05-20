package system;

import system.member.Member;

import java.io.File;
import java.util.ArrayList;

public class CompetitorManager {
  private Team[] teams;
  private ArrayList<Competition> competitions;
  private final File COMPETITORS_FILE = new File("Competitors.txt");

  public File getCOMPETITORS_FILE(){
    return COMPETITORS_FILE;
  }

  public void updateCompetitorScore(){}

  public ArrayList<Competitor> getCompetitors(ArrayList<Member> members){
    return null;
  }
}
