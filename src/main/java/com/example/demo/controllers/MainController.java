package com.example.demo.controllers;

import com.example.demo.entities.RoadsterInfo;
import com.example.demo.httpclient.HttpClient;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class MainController {

    @Value("${spacex.http.get.roadsterInfo}")
    private String httpGetRoadsterInfo;

    private final HttpClient httpClient;

    @Autowired
    public MainController(HttpClient httpClient) {
        this.httpClient = httpClient;
    }


    @GetMapping(value = "/")
    public String mainController(Model model) {
        try {
            var roadster = httpClient.get(httpGetRoadsterInfo, RoadsterInfo.class);
            model.addAttribute("roadster", roadster);
            return "index";
        } catch (Throwable e) {
            Logger.getLogger(e.getMessage());
        }
        return "error";
    }


}
