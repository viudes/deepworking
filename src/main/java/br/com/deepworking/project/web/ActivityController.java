package br.com.deepworking.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.deepworking.project.model.Project;
import br.com.deepworking.project.model.ProjectService;
import br.com.deepworking.project.web.view.ActivityEntry;

@Controller
@RequestMapping("/project/{projectId}/activity")
public class ActivityController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newActivity(@PathVariable Integer projectId) {
        ModelAndView mv = new ModelAndView("project/activity/new_activity");
        Project project = projectService.findProjectBy(projectId);

        mv.addObject("projectId", projectId);
        mv.addObject("projectName", project.getName());

        return mv;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView listAll(@PathVariable Integer projectId) {
        ModelAndView mv = new ModelAndView("project/activity/list_activities");
        return mv;
    }

    @RequestMapping(value = "/{activityId}/rate")
    public ModelAndView rateActivity(@PathVariable Integer projectId, @PathVariable Integer activityId) {
        ModelAndView mv = new ModelAndView("project/activity/rate_activity");
        return mv;
    }

    @PostMapping
    public ModelAndView save(@PathVariable Integer projectId, ActivityEntry activityEntry) {
        ModelAndView mv = new ModelAndView("redirect:/project/" + projectId);
        System.out.println(projectId);
        System.out.println(activityEntry);
        return mv;
    }
}
