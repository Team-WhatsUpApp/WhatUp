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
