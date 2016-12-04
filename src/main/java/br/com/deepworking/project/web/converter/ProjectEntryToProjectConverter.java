package br.com.deepworking.project.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.deepworking.project.model.Project;
import br.com.deepworking.project.web.view.ProjectEntry;

@Component
public class ProjectEntryToProjectConverter implements Converter<ProjectEntry, Project> {

    @Override
    public Project convert(ProjectEntry source) {
        Project project = new Project(source.getName());

        source.getActivityTypes().forEach(a -> project.addActivityType(a.getName(), a.getDescription()));

        return project;
    }

}
