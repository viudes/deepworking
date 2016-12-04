package br.com.deepworking.project.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectFolder projectFolder;

    public void addProjectToFolder(Project project) {
        projectFolder.save(project);
    }

    public Collection<Project> getAll() {
        List<Project> projects = new ArrayList<>();

        Iterable<Project> iterableProjects = projectFolder.findAll();
        iterableProjects.forEach(p -> projects.add(p));

        return Collections.unmodifiableCollection(projects);
    }

}
