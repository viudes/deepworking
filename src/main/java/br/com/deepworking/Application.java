package br.com.deepworking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.deepworking.project.model.Project;
import br.com.deepworking.project.model.ProjectFolder;
import br.com.deepworking.project.web.view.ProjectViewPresenter;

@Controller
@EnableJpaRepositories
@SpringBootApplication
public class Application {

    @Autowired
    private ProjectFolder projectFolder;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        Collection<Project> projects = projectFolder.getAllProjects();

        List<ProjectViewPresenter> projectsPresenter = new ArrayList<>();
        projects.forEach(p -> projectsPresenter.add(new ProjectViewPresenter(p)));

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("projects", projectsPresenter);

        return mv;
    }
}
