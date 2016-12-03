package br.com.deepworking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.deepworking.project.model.Project;
import br.com.deepworking.project.web.view.ProjectViewPresenter;

@Controller
@EnableJpaRepositories
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        Project project = new Project("Livro de OAuth");
        project.addActivityType("Organização");
        project.addActivityType("Pesquisa");

        List<ProjectViewPresenter> projects = new ArrayList<>();
        projects.add(new ProjectViewPresenter(project));

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("projects", projects);

        return mv;
    }
}
