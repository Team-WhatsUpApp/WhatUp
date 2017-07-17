package com.whatsup.controller;

import com.montealegreluis.yelpv3.Business;
import com.montealegreluis.yelpv3.SearchCriteria;
import com.montealegreluis.yelpv3.Yelp;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.whatsup.models.Location;
import com.whatsup.models.User;
import com.whatsup.models.Vendor;
import com.whatsup.repositories.LocationsRepository;
import com.whatsup.repositories.VendorsRepository;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.print.URIException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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
	public String vendorLocations(Model model) {
		Iterable<Location> locations = locationsDao.findAll();
		model.addAttribute("locations", locations);
		return "location/index";
	}


	@GetMapping("places/{id}")
	public String singleLocation(@PathVariable long id, Model model) {
		Location location = locationsDao.findOne(id);
		model.addAttribute("location", location);
		return "location/show";
	}


	@GetMapping("places/create")
	public String createLocation(Model model) {
		Location location = new Location();
		model.addAttribute("location", location);
		Yelp yelp = new Yelp("qoki5XUClSAHUg-8xN8eTg", "fMXre7kUwan40vX4gvBKVYirqX8s9tYFvPlKF9ZbCBA3uQTYn1fpsxyP7WBEUhxJ");
		List<Business> businessList = yelp.search(SearchCriteria.byLocation("Esquire-Tavern"));
		for (Business business : businessList) {
//			System.out.println(business.id());
		}
//		System.out.println(businessList);
		return "location/create";
	}

	public Location getYelpInfo(/*@PathVariable*/ String term/*@PathVariable String lat, @PathVariable String lon*/) throws IOException, URISyntaxException {
		CloseableHttpClient client = HttpClients.createDefault();

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("grant_type", "client_credentials"));
		formparams.add(new BasicNameValuePair("client_id", "qoki5XUClSAHUg-8xN8eTg"));
		formparams.add(new BasicNameValuePair("client_secret", "fMXre7kUwan40vX4gvBKVYirqX8s9tYFvPlKF9ZbCBA3uQTYn1fpsxyP7WBEUhxJ"));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);

		HttpPost post = new HttpPost("https://api.yelp.com/oauth2/token");
		post.setEntity(entity);
		CloseableHttpResponse response = client.execute(post);
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

		String output;
		String json = "";
		String rawData = "";
		String resultId = "";
		String streetAddress = "";
		String phoneNumber = "";
		String businessName = "";
		String url = "";
		String imageUrl = "";
		String preparedTerm = term.replaceAll(" ", "-").toLowerCase();
		double lat = 0;
		double lon = 0;

//		System.out.println(preparedTerm);

//		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			json += output;
		}
		JSONObject jsonObject = new JSONObject(json);
		String token = jsonObject.getString("access_token");
//		System.out.println(token);

		URIBuilder builder = new URIBuilder();
		builder.setScheme("https").setHost("api.yelp.com").setPath("/v3/businesses/search")
				.setParameter("location", "san antonio")
//				.setParameter("access_token", token)
//				.setParameter("latitude", lat)
//				.setParameter("longitude", lon)
				.setParameter("term", preparedTerm);
		URI uri = builder.build();

		HttpGet get = new HttpGet(uri);
		get.setHeader("Authorization", String.format("bearer %s", token));
		response = client.execute(get);
		br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		while ((output = br.readLine()) != null) {
			rawData = output;
		}

//		System.out.println(rawData);

//		JSON object created from the raw data
		JSONObject jsonBusiness = new JSONObject(rawData);

//		Make an array from the previous JSONObject
		JSONArray businesses;
		businesses = jsonBusiness.getJSONArray("businesses");

//		Get the first result
		JSONObject business = businesses.getJSONObject(0);

//		Name
		businessName = business.getString("name");

//		Yelp ID
		resultId = business.getString("id");

//		Vendor TODO: Make this actually functional, instead of just a test for now
//		Vendor vendor = vendorsDao.findById(5);
//		System.out.println(vendor.getId());

//		Concat together the street address from the location object
		JSONObject address = business.getJSONObject("location");
		streetAddress += address.getString("address1") + ", ";
		streetAddress += address.getString("city") + ", ";
		streetAddress += address.getString("state") + " ";
		streetAddress += address.getString("zip_code");

//		Phone number
		phoneNumber = business.getString("phone");

//		Getting the coordinates so we can make a point later.
		JSONObject coords = business.getJSONObject("coordinates");
		lat = coords.getDouble("latitude");
		lon = coords.getDouble("longitude");


//		And creating that point here.
		GeometryFactory geometryFactory = new GeometryFactory();
		Coordinate coordinate = new Coordinate(lon, lat);
		Point point = geometryFactory.createPoint(coordinate);

//		Yelp and Yelp image URLs
		url = business.getString("url");
		imageUrl = business.getString("image_url");

		Location location = new Location(businessName, resultId, point, streetAddress, phoneNumber, url, imageUrl);
		return location;
	}


	@PostMapping("/places/create")
	public String saveLocation(@ModelAttribute Location location, Model model) throws IOException, URISyntaxException {
		Location parsedLocation = getYelpInfo(location.getYelpId());
//		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Vendor vendor = vendorsDao.findById(1);
		parsedLocation.setVendor(vendor);
		locationsDao.save(parsedLocation);
		return "redirect:/maps";
	}
}
