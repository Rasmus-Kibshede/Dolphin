package system.menus.competitive;

import system.member.competitor.Competitor;
import system.member.competitor.Discipline;
import system.member.competitor.TrainingScore;

import java.util.Comparator;

public class CompareCompetitor implements Comparator<Competitor> {

  private Discipline discipline;

  public CompareCompetitor(Discipline discipline) {
    this.discipline = discipline;
  }

  private TrainingScore getTrainingScore(Competitor competitor) {
    for (TrainingScore trainingScore : competitor.getTrainingScores()) {
      if (trainingScore.getDISCIPLINE().equals(discipline)) {
        return trainingScore;
      }
    }
    return null;
  }

  @Override
  public int compare(Competitor original, Competitor other) {
    TrainingScore originalTrainingScore = getTrainingScore(original);
    TrainingScore otherTrainingScore = getTrainingScore(other);

    // Taking care of trainingScores is null
    if (originalTrainingScore == null && otherTrainingScore == null) {
      return 0;
    } else if (originalTrainingScore == null) {
      return 1;
    } else if (otherTrainingScore == null) {
      return -1;
    }

    return originalTrainingScore.compareTo(otherTrainingScore);
  }
}
