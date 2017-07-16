package com.whatsup.controller;

import com.whatsup.models.Location;
import com.whatsup.models.User;
import com.whatsup.models.Vendor;
import com.whatsup.repositories.LocationsRepository;
import com.whatsup.repositories.VendorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by mosesfranco on 7/15/17
 * Codeup
 * Pinnacles
 */

@Controller
public class LocationController {

	@Autowired
	VendorsRepository vendorsDao;

	@Autowired
	LocationsRepository locationsDao;

	@GetMapping("/places")
	public String vendorLocations(Model model){
		Iterable<Location> locations = locationsDao.findAll();
		model.addAttribute("locations", locations);
		return "location/index";
	}

	@PostMapping("/places/create")
	public String createLocation(@ModelAttribute Location location, Model model){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Vendor vendor = vendorsDao.findByOwner(user);
		location.setVendor(vendor);
		locationsDao.save(location);
		return "location/index";
	}
}
