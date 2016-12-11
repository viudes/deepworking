package br.com.deepworking.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.deepworking.project.model.repository.ActivityRepository;
import br.com.deepworking.project.model.repository.ScoreRepository;

@Component
public class Ratings {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    public ActivityRating findActivityBy(Integer id) {
        Activity activity = activityRepository.findOne(id);
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
