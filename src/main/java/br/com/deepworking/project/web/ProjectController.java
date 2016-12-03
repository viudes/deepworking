package br.com.deepworking.project.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.deepworking.project.model.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listAll() {
        Project project = new Project("Livro de OAuth");
        project.addActivityType("Organização");
        project.addActivityType("Pesquisa");

        List<Project> projects = new ArrayList<>();
        projects.add(project);

        ModelAndView mv = new ModelAndView("project/list_projects");
        mv.addObject("projects", projects);

        return mv;
    }

    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    public ModelAndView details(@PathVariable String projectId) {
        return new ModelAndView("project/project_details");
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public ModelAndView newProject(Project project) {
        return form("project/new_project", project);
    }

    private ModelAndView form(String path, Project project) {
        ModelAndView mv = new ModelAndView(path);
        mv.addObject("project", project);
        return mv;
    }

}
