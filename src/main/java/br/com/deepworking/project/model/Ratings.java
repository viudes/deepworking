package br.com.deepworking.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.deepworking.project.model.exception.InvalidActivityRatingException;
import br.com.deepworking.project.model.repository.ActivityRepository;
import br.com.deepworking.project.model.repository.ScoreRepository;

@Component
public class Ratings {

    private ActivityRepository activityRepository;

    private ScoreRepository scoreRepository;

    @Autowired
    public void setActivityRepository(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Autowired
    public void setScoreRepository(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public ActivityRating findActivityBy(Integer id) {
        Activity activity = activityRepository.findOne(id);

        if (activity == null) {
            throw new InvalidActivityRatingException();
        }

        return new DefaultActivityRating(activity);
    }

    private class DefaultActivityRating implements ActivityRating {

        private Activity activity;

        DefaultActivityRating(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void applyScore(Score score) {
            score.setActivity(activity);
            activity.setScore(score);

            scoreRepository.save(score);
        }

    }
}
