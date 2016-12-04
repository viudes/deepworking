package br.com.deepworking.project.web.view;

import java.util.stream.Collectors;

import br.com.deepworking.project.model.Project;

public class ProjectViewPresenter {

    private Project project;

    public ProjectViewPresenter(Project project) {
        this.project = project;
    }

    public String getName() {
        return project.getName();
    }

    public String getActivityTypes() {
        return project.getActivityTypes().stream()
            .map((type) -> type.getName())
            .collect(Collectors.joining(", "));
    }

}
