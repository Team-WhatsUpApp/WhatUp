package com.whatsup.controller;


import com.whatsup.repositories.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by DelMonroe on 7/2/17.
 */
@RestController
public class TestController {

    @Autowired
    LocationsRepository locationsDao;

    @RequestMapping("/testpage")
    public String home() {
        List<String> locations = locationsDao.getLocationsMap("-98.489576", "29.426786", "POINT(-98.489576 29.426786)");

        for (String location : locations) {
            System.out.println(location);
        }

        return "Hello! ... I am working!!!!";
    }

}
