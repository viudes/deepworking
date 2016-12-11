package br.com.deepworking.project.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.deepworking.project.model.repository.ActivityRepository;
import br.com.deepworking.project.model.repository.ProjectRepository;

@Component
public class ProjectFolder {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ActivityRepository activityRepository;

    public ProjectActivities findProjectById(int projectId) {
        Project project = projectRepository.findById(projectId);

        return new DefaultProjectActivities(project);
    }

    public void addProjectToFolder(Project project) {
        projectRepository.save(project);
    }

    public Collection<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();

        Iterable<Project> iterableProjects = projectRepository.findAll();
        iterableProjects.forEach(p -> projects.add(p));

        return Collections.unmodifiableCollection(projects);
    }

    private class DefaultProjectActivities implements ProjectActivities {

        private Project project;

        public DefaultProjectActivities(Project project) {
            this.project = project;
        }

        public Project get() {
            return project;
        }

        public void addActivity(Activity activity) {
            activity.setProject(project);
            activityRepository.save(activity);
        }

        public ActivityType getActivityTypeBy(String activityType) {

            Optional<ActivityType> found = project.findBy(activityType);

            if (!found.isPresent()) {
                project.addActivityType(activityType, null);
                projectRepository.save(project);

                return project.findBy(activityType).get();
            }

            return found.get();

        }

        public Collection<ActivityType> getActivityTypes() {
            return project.getActivityTypes();
        }

        @Override
        public Collection<Activity> findActivities() {
            return Collections.unmodifiableCollection(
                    activityRepository.findByProjectOrderByStartTimeAsc(project));
        }

    }

}
