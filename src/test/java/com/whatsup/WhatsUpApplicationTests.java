/*
package com.whatsup;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.whatsup.models.Location;
import com.whatsup.models.User;
import com.whatsup.models.UserRole;
import com.whatsup.models.Vendor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WhatsUpApplicationTests {

	@Test
	public void contextLoads() {
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

	}

}
*/
