package com.whatsup.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mosesfranco on 7/5/17
 * Codeup
 * Pinnacles
 */

@Entity
@Table(name = "locations")
//@NamedStoredProcedureQuery(
//		name = "getLocations", // name of stored procedure in the persistence unit
//		procedureName = "getLocations", //name of  stored procedure in the database
//		parameters = //Parameters of the stored procedure
//				{
//						@StoredProcedureParameter(// A parameter,
//								name = "lat", //Name of the parameter
//								mode = ParameterMode.IN, // Mode of the parameter
//								type = double.class), // JDBC Type.
//						@StoredProcedureParameter(// A parameter,
//								name = "long", //Name of the parameter
//								mode = ParameterMode.IN, // Mode of the parameter
//								type = double.class),
//						@StoredProcedureParameter(// A parameter,
//								name = "point", //Name of the parameter
//								mode = ParameterMode.IN, // Mode of the parameter
//								type = String.class)
//				}
//)
public class Location implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String yelpId;

	@OneToOne
	private Vendor vendor;

	@Column(name = "location")
	@JsonIgnore
	private Point location;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="location_has_coupons",
			joinColumns={@JoinColumn(name="location_id")},
			inverseJoinColumns={@JoinColumn(name="coupon_id")}
	)
	@JsonIgnore
	private List<Coupon> couponList;

	private double x;
	private double y;

	public Location() {
	}

	public Location(Vendor vendor, Point location) {
		this.vendor = vendor;
		this.location = location;
	}

	@JsonProperty("x")
	public double getX() {
		return this.location.getX();
	}


	public void setX(double x) {
		this.x = x;
	}

	@JsonProperty("y")
	public double getY() {
		return this.location.getY();
	}

	public void setY(double y) {
		this.y = y;
	}

	public Point getLocation() {
		return location;
	}

	public String getYelpId() {
		return yelpId;
	}

	public void setYelpId(String yelpId) {
		this.yelpId = yelpId;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public List<Coupon> getCouponList() {
		return couponList;
	}

	public void setCouponList(List<Coupon> couponList) {
		this.couponList = couponList;
	}
}
