package br.com.deepworking.project.web.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import br.com.deepworking.project.model.exception.InvalidActivityRatingException;
import br.com.deepworking.project.model.exception.ResourceNotFoundException;

@ControllerAdvice
public class DeepWorkExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView resourceNotFound() {
        ModelAndView mav = new ModelAndView("resource_not_found");
        return mav;
    }

    @ExceptionHandler(InvalidActivityRatingException.class)
    public ModelAndView invalidActivityRating() {
        ModelAndView mav = new ModelAndView("project/activity/invalid_activity_rating");
        return mav;
    }
}
