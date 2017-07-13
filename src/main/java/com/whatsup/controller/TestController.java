package com.whatsup.controller;


import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.whatsup.models.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DelMonroe on 7/2/17.
 */
@RestController
public class TestController {

	/*@Autowired
	LocationsRepository locationsDao;
	@Autowired
	UsersRepository usersDao;
	@Autowired
	VendorsRepository vendorsDao;
	@Autowired
	CouponsRepository couponsDao;
	@Autowired
	Roles rolesDao;*/

	@RequestMapping("/testpage")

	public String home() {
//        GeometryFactory geometryFactory = new GeometryFactory();
//        Coordinate coordinate = new Coordinate(-98.489894, 29.426936);
//        Point point = geometryFactory.createPoint(coordinate);
//        Location location = new Location();
//        location.setLocation(point);
//
//        locationsDao.save(location);


//		Create users
		User user1 = new User("user1", "user1@email.com", "password", "John", "Smith", 2105551234);
		User user2 = new User("user2", "user2@email.com", "password", "John", "Doe", 2105552345);
		User user3 = new User("user3", "user3@email.com", "password", "Jane", "Smith", 2105553456);
		User user4 = new User("user4", "user4@email.com", "password", "Jane", "Doe", 2105554567);
		User user5 = new User("user5", "user5@email.com", "password", "Beyonce", "Knowles", 2105555678);

//		Hard coded roles
		UserRole role1 = new UserRole(1, "VENDOR");
		UserRole role2 = new UserRole(2, "VENDOR");
		UserRole role3 = new UserRole(3, "VENDOR");
		UserRole role4 = new UserRole(4, "VENDOR");
		UserRole role5 = new UserRole(5, "VENDOR");

//		Each user is a going to be a vendor, so we are making `Vendor` objects for them
		Vendor vendor1 = new Vendor(user1, "La Panaderia Bakery Cafe");
		vendor1.setValidated(true);

		Vendor vendor2 = new Vendor(user2, "Sip Brew Bar & Eatery");
		vendor2.setValidated(true);

		Vendor vendor3 = new Vendor(user3, "The Esquire Tavern");
		vendor3.setValidated(true);

		Vendor vendor4 = new Vendor(user4, "Schillo's");
		vendor4.setValidated(true);

		Vendor vendor5 = new Vendor(user5, "Whiskey Cafe");
		vendor5.setValidated(true);

//		Create a `Point` object, that will be assigned to a new `Location`, attached to each `Vendor`
		GeometryFactory geometryFactory = new GeometryFactory();

		Coordinate c1 = new Coordinate(-98.489569, 29.426583);
		Point p1 = geometryFactory.createPoint(c1);
		Location downtown1 = new Location(vendor1, p1);

		Coordinate c2 = new Coordinate(-98.491509, 29.426327);
		Point p2 = geometryFactory.createPoint(c2);
		Location downtown2 = new Location(vendor2, p2);

		Coordinate c3 = new Coordinate(-98.491771, 29.424707);
		Point p3 = geometryFactory.createPoint(c3);
		Location downtown3 = new Location(vendor3, p3);

		Coordinate c4 = new Coordinate(-98.488286, 29.423706);
		Point p4 = geometryFactory.createPoint(c4);
		Location downtown4 = new Location(vendor4, p4);

		Coordinate c5 = new Coordinate(-98.611466, 29.593212);
		Point p5 = geometryFactory.createPoint(c5);
		Location downtown5 = new Location(vendor5, p5);

//		Create a `Coupon`, also attached to a `Vendor`
		Date day1 = new Date(System.currentTimeMillis());
		Coupon coupon1 = new Coupon("FOO1", day1, day1, "Title 1", "Value 1", "Description 1", "Restriction 1", 100, vendor1);
		Coupon coupon2 = new Coupon("FOO2", day1, day1, "Title 2", "Value 2", "Description 2", "Restriction 2", 100, vendor2);
		Coupon coupon3 = new Coupon("FOO3", day1, day1, "Title 3", "Value 3", "Description 3", "Restriction 3", 100, vendor3);
		Coupon coupon4 = new Coupon("FOO4", day1, day1, "Title 4", "Value 4", "Description 4", "Restriction 4", 100, vendor4);
		Coupon coupon5 = new Coupon("FOO5", day1, day1, "Title 5", "Value 5", "Description 5", "Restriction 5", 100, vendor5);

//		Creating a List of `Coupons` and adding them to each location
		List<Coupon> couponList1 = new ArrayList<>();
		couponList1.add(coupon1);
		downtown1.setCouponList(couponList1);

		List<Coupon> couponList2 = new ArrayList<>();
		couponList2.add(coupon2);
		downtown2.setCouponList(couponList2);

		List<Coupon> couponList3 = new ArrayList<>();
		couponList3.add(coupon3);
		downtown3.setCouponList(couponList3);

		List<Coupon> couponList4 = new ArrayList<>();
		couponList4.add(coupon4);
		downtown4.setCouponList(couponList4);

		List<Coupon> couponList5 = new ArrayList<>();
		couponList5.add(coupon5);
		downtown5.setCouponList(couponList5);


//		usersDao.save(user1);
//		usersDao.save(user2);
//		usersDao.save(user3);
//		usersDao.save(user4);
//		usersDao.save(user5);
//		rolesDao.save(role1);
//		rolesDao.save(role2);
//		rolesDao.save(role3);
//		rolesDao.save(role4);
//		rolesDao.save(role5);
//		vendorsDao.save(vendor1);
//		vendorsDao.save(vendor2);
//		vendorsDao.save(vendor3);
//		vendorsDao.save(vendor4);
//		vendorsDao.save(vendor5);
//		locationsDao.save(downtown1);
//		locationsDao.save(downtown2);
//		locationsDao.save(downtown3);
//		locationsDao.save(downtown4);
//		locationsDao.save(downtown5);
//		couponsDao.save(coupon1);
//		couponsDao.save(coupon2);
//		couponsDao.save(coupon3);
//		couponsDao.save(coupon4);
//		couponsDao.save(coupon5);

//		List<Location> locations = locationsDao.getLocationsMap(-98.489576, 29.426786, 1);
//		System.out.println(Arrays.toString(locations.toArray()));
//		for (Location location : locations) {
//			System.out.println(location.getId() + " " + location.getLocation().getX() + " " + location.getLocation().getY());
//		}

		return "Hello! ... I am working!!!!";
	}
}
