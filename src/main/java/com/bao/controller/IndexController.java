package com.bao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by chenzhang on 2016/10/14.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public ModelAndView test() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("hello guys");
        return mv;
    }
}
