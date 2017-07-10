package com.whatsup.controller;


import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.whatsup.models.Location;
import com.whatsup.repositories.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import com.vividsolutions.jts.geom.Point;

/**
 * Created by DelMonroe on 7/2/17.
 */
@RestController
public class TestController {

	@Autowired
	LocationsRepository locationsDao;

	@RequestMapping("/testpage")

	public String home() {
//        GeometryFactory geometryFactory = new GeometryFactory();
//        Coordinate coordinate = new Coordinate(-98.489894, 29.426936);
//        Point point = geometryFactory.createPoint(coordinate);
//        Location location = new Location();
//        location.setLocation(point);
//
//        locationsDao.save(location);


		List<Location> locations = locationsDao.getLocationsMap(-98.489576, 29.426786, 10);
		System.out.println(Arrays.toString(locations.toArray()));
		for (Location location : locations) {
			System.out.println(location.getId() + " " + location.getLocation().getX() + " " + location.getLocation().getY());
		}

		return "Hello! ... I am working!!!!";
	}

}
