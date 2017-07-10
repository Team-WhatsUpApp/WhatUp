package com.whatsup.models;


import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;
import java.io.Serializable;

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

	@OneToOne
	private Vendor owner;

	@Column(name = "location")
	private Point location;

	public Location(Vendor owner, Point location) {
		this.owner = owner;
		this.location = location;
	}

	public Location() {
	}

	public Point getLocation() {
		return location;
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

	public Vendor getOwner() {
		return owner;
	}

	public void setOwner(Vendor owner) {
		this.owner = owner;
	}
}
