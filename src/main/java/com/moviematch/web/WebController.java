package com.moviematch.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String landingPage() {
        return "landing";
    }

    @RequestMapping("/match")
    public String match() {
        return "match";
    }

}
