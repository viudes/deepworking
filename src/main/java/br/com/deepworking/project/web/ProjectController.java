package br.com.deepworking.project.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.deepworking.project.model.Label;
import br.com.deepworking.project.model.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listAll() {
        Project project = new Project("Livro de OAuth");
        project.addLabel(new Label("Organização", "Estruturar como seguir os próximos passos em conjunto com pesquisa"));
        project.addLabel(new Label("Pesquisa", "Pesquisa sobre o assunto a ser escrito e coleta de material"));

        List<Project> projects = new ArrayList<>();
        projects.add(project);

        ModelAndView mv = new ModelAndView("project/list_projects");
        mv.addObject("projects", projects);

        return mv;
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
