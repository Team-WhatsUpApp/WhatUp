package com.whatsup.controller;



import com.whatsup.models.Location;
import com.whatsup.repositories.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by mosesfranco on 7/13/17
 * Codeup
 * Pinnacles
 */
@Controller
public class MapController {

	@Autowired
	private LocationsRepository locationsDao;

	@GetMapping("/maps/geo")
	public String loadMap(/*@PathVariable double lon, @PathVariable double lat, @PathVariable double dist, Model model*/){
//		Iterable<Location> results = locationsDao.getLocationsMap(lon, lat, dist/2);
//		model.addAttribute("results", results);
		return "map/map";
	}


	@GetMapping("/locations.json/{lon}/{lat}/{dist}")
	public @ResponseBody Iterable<Location>  locations(@PathVariable double lon, @PathVariable double lat, @PathVariable double dist, Model model) {
		return locationsDao.getLocationsMap(lon, lat, dist/2);
		//model.addAttribute("results", results);
		//return "map/map";
	}

}
