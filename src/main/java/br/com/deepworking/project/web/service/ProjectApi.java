package br.com.deepworking.project.web.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deepworking.project.model.ActivityType;
import br.com.deepworking.project.model.ProjectFolder;

@RestController
@RequestMapping("/project")
public class ProjectApi {

    @Autowired
    private ProjectFolder projectFolder;

    @GetMapping("{projectId}/activityTypes")
    public Collection<ActivityTypeTO> activityTypes(@PathVariable("projectId") Integer projectId) {

        Collection<ActivityType> activityTypes = projectFolder
                .findProjectById(projectId)
                .getActivityTypes();

        return activityTypes.stream()
            .map(a -> new ActivityTypeTO(a.getName()))
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public static class ActivityTypeTO implements Serializable {
        private static final long serialVersionUID = 1L;

        private String name;

        public ActivityTypeTO(String name) {
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
