package com.example.demo.controllers;

import com.example.demo.httpclient.HttpClientImp;
import com.example.demo.entities.RoadsterInfo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Value("${spacex.http.get.roadsterInfo}")
    private String httpGetRoadsterInfo;

    private HttpClientImp httpImp;

    @Autowired
    public MainController(HttpClientImp httpImp) {
        this.httpImp = httpImp;
    }

    @RequestMapping(value = "/")
    public String mainController(Model model) {
        try {
            var roadster = httpImp.get(httpGetRoadsterInfo, RoadsterInfo.class);
            model.addAttribute("roadster", roadster);
            return "index";
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        return "error";
    }
}
