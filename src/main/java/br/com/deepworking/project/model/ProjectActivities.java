package br.com.deepworking.project.model;

import java.util.Collection;

public interface ProjectActivities {

    Project get();

    void addActivity(Activity activity);

    ActivityType getActivityTypeBy(String activityType);

    Collection<ActivityType> getActivityTypes();

}
