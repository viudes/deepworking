package br.com.deepworking.project.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.deepworking.project.model.Ratings;
import br.com.deepworking.project.model.factory.ScoreFactory;
import br.com.deepworking.project.model.transfer.RatingEntry;

@Controller
@RequestMapping("/project/{projectId}/activity/{activityId}")
public class RateController {

    @Autowired
    private Ratings ratings;

    @Autowired
    private ScoreFactory scoreFactory;

    @GetMapping(value = "/rate")
    public ModelAndView rateActivity(@PathVariable Integer projectId,
            @PathVariable Integer activityId, RatingEntry rating) {

        ModelAndView mv = new ModelAndView("project/activity/rate_activity");

        mv.addObject("projectId", projectId);
        mv.addObject("activityId", activityId);
        mv.addObject("rating", rating);

        return mv;
    }

    @PostMapping
    public ModelAndView applyRating(@PathVariable Integer projectId, @PathVariable Integer activityId,
            @Valid RatingEntry rating, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            return rateActivity(projectId, activityId, rating);
        }

        ratings
            .findActivityBy(activityId)
            .applyScore(scoreFactory.createFrom(rating));

        return new ModelAndView(String.format(
                "redirect:/project/%s/activity", projectId));
    }
}
