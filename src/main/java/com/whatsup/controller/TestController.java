package com.whatsup.controller;


import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.whatsup.models.*;
import com.whatsup.repositories.CouponsRepository;
import com.whatsup.repositories.LocationsRepository;
import com.whatsup.repositories.UsersRepository;
import com.whatsup.repositories.VendorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.vividsolutions.jts.geom.Point;

/**
 * Created by DelMonroe on 7/2/17.
 */
@RestController
public class TestController {

	@Autowired
	LocationsRepository locationsDao;
	@Autowired
	UsersRepository usersDao;
	@Autowired
	VendorsRepository vendorsDao;
	@Autowired
	CouponsRepository couponsDao;

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

		User moses = new User("mo", "mo@mo.com", "blarghpass", "Moses", "Franco", 2105551234);
		User frank = new User("frank", "frank@frank.com", "passblargh", "Frank", "Foo", 2105554321);

		UserRole testing1 = new UserRole(1, "ADMIN");
		UserRole testing2 = new UserRole(2, "ADMIN");

		Vendor cakes = new Vendor(moses, "Cakes Galore");
		cakes.setValidated(true);

		Vendor coffee = new Vendor(frank, "Covfefe");
		coffee.setValidated(false);


		GeometryFactory geometryFactory = new GeometryFactory();

		Coordinate c1 = new Coordinate(-98.489567, 29.426582);
		Point p1 = geometryFactory.createPoint(c1);
		Location downtown1 = new Location(cakes, p1);

		Coordinate c2 = new Coordinate(-98.491510, 29.426329);
		Point p2 = geometryFactory.createPoint(c2);
		Location downtown2 = new Location(coffee, p2);


		Date day1 = new Date(System.currentTimeMillis());
		Date day2 = new Date(System.currentTimeMillis()+10000);
		Coupon coupon1 = new Coupon("FOO", day1, day2, "Free FOO", "Don't pay for foo", "Come get some foo", "For foo, no restrictions", 100, cakes);

		Date day3 = new Date(System.currentTimeMillis()+20000);
		Date day4 = new Date(System.currentTimeMillis()+30000);
		Coupon coupon2 = new Coupon("FOO", day1, day2, "Free FOO", "Don't pay for foo", "Come get some foo", "For foo, no restrictions", 100, coffee);

		List<Coupon> couponList1 = new ArrayList<>();
		couponList1.add(coupon1);

		List<Coupon> couponList2 = new ArrayList<>();
		couponList1.add(coupon2);

		downtown1.setCouponList(couponList1);
		downtown2.setCouponList(couponList2);

		usersDao.save(moses);
		usersDao.save(frank);
		vendorsDao.save(cakes);
		vendorsDao.save(coffee);
		locationsDao.save(downtown1);
		locationsDao.save(downtown2);
		couponsDao.save(coupon1);
		couponsDao.save(coupon2);

		return "Hello! ... I am working!!!!";
	}

}
