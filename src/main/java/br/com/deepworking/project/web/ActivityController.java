package br.com.deepworking.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/project/{projectId}/activity")
public class ActivityController {

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newActivity(@PathVariable Integer projectId) {
        ModelAndView mv = new ModelAndView("project/activity/new_activity");
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

}
