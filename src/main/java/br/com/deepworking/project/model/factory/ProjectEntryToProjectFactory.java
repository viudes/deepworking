package br.com.deepworking.project.model.factory;

import org.springframework.stereotype.Component;

import br.com.deepworking.project.model.Project;
import br.com.deepworking.project.model.transfer.ProjectEntry;

@Component
public class ProjectEntryToProjectFactory {

    public Project createFrom(ProjectEntry source) {
        Project project = new Project(source.getName());

        source.getActivityTypes().forEach(a -> project.addActivityType(a.getName(), a.getDescription()));

        return project;
    }

}
