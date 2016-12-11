package br.com.deepworking.project.model.factory;

import org.springframework.stereotype.Component;

import br.com.deepworking.project.model.Score;
import br.com.deepworking.project.model.ScorePoint;
import br.com.deepworking.project.model.transfer.RatingEntry;

@Component
public class ScoreFactory {

    public Score createFrom(RatingEntry ratingEntry) {
        Score score = new Score();

        score.setInterruptions(ratingEntry.getInterruptions());
        score.setNotes(ratingEntry.getNotes());
        score.setPoints(ScorePoint.fromInteger(ratingEntry.getScorePoint()));

        return score;
    }

}
