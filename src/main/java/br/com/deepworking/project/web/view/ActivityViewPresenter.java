package br.com.deepworking.project.web.view;

import java.time.format.DateTimeFormatter;

import br.com.deepworking.project.model.Activity;

public class ActivityViewPresenter {

    private Activity activity;

    public ActivityViewPresenter(Activity activity) {
        this.activity = activity;
    }

    public Integer getId() {
        return activity.getId();
    }

    public String getStartDate() {
        return activity.getStartTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String getType() {
        return activity.getActivityType().getName();
    }

    public String getStartTime() {
        return activity.getStartTime().format(DateTimeFormatter.ISO_LOCAL_TIME);
    }

    public Integer getAmountInMinutes() {
        return activity.getAmountTimeInMinutes();
    }

    public String getDescription() {
        return activity.getDescription();
    }

    public String getRating() {
        String rating = "-";

        if (activity.getScore() != null) {
            rating = activity.getScore().getPoints().name();
        }

        return rating;
    }

    public int getInterruptions() {
        int interruptions = 0;

        if (activity.getScore() != null) {
            interruptions = activity.getScore().getInterruptions();
        }

        return interruptions;
    }

    public boolean isRated() {
        return activity.getScore() != null;
    }

    @Override
    public String toString() {
        return "ActivityViewPresenter [activity=" + activity + "]";
    }

}
