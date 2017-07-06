package com.whatsup.models;

import javax.persistence.*;
import java.util.Date;

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

	@Column(name = "vendor_id")
	private Vendor owner;

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
}
