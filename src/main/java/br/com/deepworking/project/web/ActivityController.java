package br.com.deepworking.project.web;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.deepworking.project.model.Activity;
import br.com.deepworking.project.model.Project;
import br.com.deepworking.project.model.ProjectFolder;
import br.com.deepworking.project.model.factory.ActivityEntryFactory;
import br.com.deepworking.project.model.transfer.ActivityEntry;
import br.com.deepworking.project.web.view.ActivitiesViewPresenter;

@Controller
@RequestMapping("/project/{projectId}/activity")
public class ActivityController {

    @Autowired
    private ProjectFolder projectFolder;

    @Autowired
    private ActivityEntryFactory activityEntryFactory;

    @GetMapping(value = "/new")
    public ModelAndView newActivity(@PathVariable Integer projectId, ActivityEntry activityEntry) {
        ModelAndView mv = new ModelAndView("project/activity/new_activity");
        Project project = projectFolder.findProjectById(projectId).get();

        mv.addObject("projectId", projectId);
        mv.addObject("projectName", project.getName());
        mv.addObject("activityEntry", activityEntry);

        return mv;
    }

    @GetMapping
    public ModelAndView listAll(@PathVariable Integer projectId) {
        ModelAndView mv = new ModelAndView("project/activity/list_activities");

        Collection<Activity> activities = projectFolder
            .findProjectById(projectId)
            .findActivities();

        ActivitiesViewPresenter presenter = new ActivitiesViewPresenter(activities);

        mv.addObject("projectName", projectFolder.findProjectById(projectId).get().getName());
        mv.addObject("projectId", projectId);
        mv.addObject("activities", presenter);
        return mv;
    }

    @GetMapping(value = "/{activityId}/rate")
    public ModelAndView rateActivity(@PathVariable Integer projectId, @PathVariable Integer activityId) {
        ModelAndView mv = new ModelAndView("project/activity/rate_activity");
        return mv;
    }

    @PostMapping
    public ModelAndView save(@PathVariable Integer projectId, @Valid ActivityEntry activityEntry,
            BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            return newActivity(projectId, activityEntry);
        }

        Activity activity = activityEntryFactory.createFrom(activityEntry);

        projectFolder
            .findProjectById(projectId)
            .addActivity(activity);

        ModelAndView mv = new ModelAndView("redirect:/project/" + projectId);
        return mv;
    }
}
