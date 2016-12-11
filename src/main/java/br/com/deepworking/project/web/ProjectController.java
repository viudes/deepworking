package br.com.deepworking.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.deepworking.project.model.Project;
import br.com.deepworking.project.model.ProjectFolder;
import br.com.deepworking.project.model.factory.ProjectFactory;
import br.com.deepworking.project.model.transfer.ProjectEntry;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectFactory projectFactory;

    @Autowired
    private ProjectFolder projectFolder;

    @GetMapping("/{projectId}")
    public ModelAndView details(@PathVariable Integer projectId) {
        ModelAndView mv = new ModelAndView("project/project_details");

        Project project = projectFolder.findProjectById(projectId).get();

        mv.addObject("projectId", projectId);
        mv.addObject("projectName", project.getName());

        return mv;
    }

    @GetMapping("new")
    public ModelAndView newProject(ProjectEntry projectEntry) {
        return form("project/new_project", projectEntry);
    }

    private ModelAndView form(String path, ProjectEntry project) {
        ModelAndView mv = new ModelAndView(path);
        mv.addObject("projectEntry", project);
        return mv;
    }

    @PostMapping("save")
    public ModelAndView save(ProjectEntry projectEntry) {
        Project project = projectFactory.createFrom(projectEntry);

        projectFolder.addProjectToFolder(project);

        return new ModelAndView("redirect:/");
    }

}
