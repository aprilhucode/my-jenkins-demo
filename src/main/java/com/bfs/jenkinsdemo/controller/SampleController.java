package com.bfs.jenkinsdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/samples")
    public String getAllSamples() {
        return "Hello World";
    }

    @GetMapping("/samples/{id}")
    public String getSampleById(@PathVariable Integer id) {
        return "sample id: " + id;
    }

}
