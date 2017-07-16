package com.whatsup.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.whatsup.models.Location;
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
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DelMonroe on 7/11/17.
 */
@Controller
public class MVCController {

	@Autowired
	VendorsRepository vendorsDao;
	@Autowired
	LocationsRepository locationDao;

	@RequestMapping(path = "/admin", method = RequestMethod.GET)
	public String adminPage() {
		return "dashboard_admin";
	}


	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public String userPage() {
		return "dashboard_user";
	}


	@RequestMapping(path = "/yelp/{term}", method = RequestMethod.GET)
	@ResponseBody
	public String getYelpId(@PathVariable String term/*@PathVariable String lat, @PathVariable String lon*/) throws IOException, URISyntaxException {
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
		String url = "";
		String imageUrl = "";
		double lat = 0;
		double lon = 0;
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
				.setParameter("term", term);
		URI uri = builder.build();

		HttpGet get = new HttpGet(uri);
		get.setHeader("Authorization", String.format("bearer %s", token));
		response = client.execute(get);
		br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		while ((output = br.readLine()) != null) {
			rawData = output;
		}

		System.out.println(rawData);

//		JSONObject jsonBusiness = new JSONObject(rawData);
//		JSONArray businesses;
//
//		businesses = jsonBusiness.getJSONArray("businesses");
//
//		JSONObject business = businesses.getJSONObject(0);
//		resultId = business.getString("id");
//		JSONObject address = business.getJSONObject("location");
//		streetAddress += address.getString("address1") + ", ";
//		streetAddress += address.getString("city")+ ", ";
//		streetAddress += address.getString("state")+ " ";
//		streetAddress += address.getString("zip_code");
//		phoneNumber += business.getString("phone");
//		JSONObject coords = business.getJSONObject("coordinates");
//		lat = coords.getDouble("latitude");
//		lon = coords.getDouble("longitude");
//
//
//		Location location = new Location();
//		location.setYelpId(resultId);
//		GeometryFactory geometryFactory = new GeometryFactory();
//		Coordinate coordinate = new Coordinate(lon, lat);
//		Point point = geometryFactory.createPoint(coordinate);
//		location.setLocation(point);
//		Vendor vendor = vendorsDao.findById(7);
//		location.setVendor(vendor);
//		System.out.println(business.getString("name"));
//		System.out.println(streetAddress);
//		System.out.println(phoneNumber);
//		System.out.println(business.getString("url"));
//		System.out.println(business.getString("image_url"));
////		locationDao.save(location);

		return rawData;
	}
}

