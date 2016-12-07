package br.com.deepworking.project.model.factory;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.deepworking.project.model.Activity;
import br.com.deepworking.project.model.ActivityType;
import br.com.deepworking.project.model.ProjectFolder;
import br.com.deepworking.project.model.SimpleTime;
import br.com.deepworking.project.model.transfer.ActivityEntry;
import br.com.deepworking.util.DateUtils;

@Component
public class ActivityEntryFactory {

    @Autowired
    private ProjectFolder projectFolder;

    public Activity createFrom(ActivityEntry source) {

        Activity activity = new Activity();

        ActivityType activityType = projectFolder
            .findProjectById(source.getProjectId())
            .getActivityTypeBy(source.getActivityType());

        activity.setActivityType(activityType);
        activity.setAmountTimeInMinutes(source.getAmountTimeInMinutes());
        activity.setDescription(source.getDescription());
        activity.setProject(activityType.getProject());

        SimpleTime time = new SimpleTime(source.getStartTime());
        OffsetDateTime startTime = DateUtils.getOffsetDateTimeFromDateAndTime(source.getDate(), time);
        activity.setStartTime(startTime);

        return activity;
    }

}
