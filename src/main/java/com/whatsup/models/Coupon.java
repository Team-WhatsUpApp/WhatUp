package com.whatsup.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by mosesfranco on 7/5/17
 * Codeup
 * Pinnacles
 */

@Entity
@Table(name = "coupons")
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


	@Column(name = "code")
	private String couponCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_datetime")
	private Date startDatetime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_datetime")
	private Date endDatetime;

	@Column(name = "title")
	private String title;

	@Column(name = "value")
	private String value;

	@Column(name = "description", columnDefinition = "text")
	private String description;

	@Column(name = "restrictions", columnDefinition = "text")
	private String restrictions;

	@Column(name = "remaining_uses")
	private int remainingUses;

	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor owner;

	@ManyToMany(mappedBy = "couponList")
	private List<Location> locationList;

	@ManyToMany(mappedBy = "userCouponList")
	private List<User> userList;

	public Coupon() {
	}

	public Coupon(Coupon coupon) {
		this.owner = coupon.owner;
		this.couponCode = coupon.couponCode;
		this.startDatetime = coupon.startDatetime;
		this.endDatetime = coupon.endDatetime;
		this.title = coupon.title;
		this.value = coupon.value;
		this.description = coupon.description;
		this.restrictions = coupon.restrictions;
		this.remainingUses = coupon.remainingUses;
	}

	public Coupon(String couponCode, Date startDatetime, Date endDatetime, String title, String value, String description, String restrictions, int remainingUses, Vendor owner) {
		this.couponCode = couponCode;
		this.startDatetime = startDatetime;
		this.endDatetime = endDatetime;
		this.title = title;
		this.value = value;
		this.description = description;
		this.restrictions = restrictions;
		this.remainingUses = remainingUses;
		this.owner = owner;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Date getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(Date startDatetime) {
		this.startDatetime = startDatetime;
	}

	public Date getEndDatetime() {
		return endDatetime;
	}

	public void setEndDatetime(Date endDatetime) {
		this.endDatetime = endDatetime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(String restrictions) {
		this.restrictions = restrictions;
	}

	public int getRemainingUses() {
		return remainingUses;
	}

	public void setRemainingUses(int remainingUses) {
		this.remainingUses = remainingUses;
	}

	public Vendor getOwner() {
		return owner;
	}

	public void setOwner(Vendor owner) {
		this.owner = owner;
	}

	public List<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
