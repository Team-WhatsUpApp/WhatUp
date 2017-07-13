package com.whatsup.model;

import com.whatsup.repository.VendorRepository;

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

    @ManyToOne
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

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vendor owner() {return this.owner;}

    public void setOwner(Vendor owner) {this.owner = owner;}

    public String getCouponCode() {return this.couponCode;}

    public void setCouponCode(String couponCode) {this.couponCode = couponCode;}

    public Date getStartDatetime() {return this.startDatetime;}

    public void setStartDatetime(Date startDatetime) {this.startDatetime = startDatetime;}

    public Date getEndDatetime() {return this.endDatetime;}

    public void setEndDatetime(Date endDatetime) {this.endDatetime = endDatetime;}

    public String getTitle() {return this.title;}

    public void setTitle(String title) {this.title = title;}

    public String getValue() {return this.value;}

    public void setValue(String value) {this.value = value;}

    public String getDescription() {return this.description;}

    public void setDescription(String description) {this.description = description;}

    public String getRestrictions() {return this.restrictions;}

    public void setRestrictions(String restrictions) {this.restrictions = restrictions;}

    public int getRemainingUses() {return this.remainingUses;}

    public void setRemainingUses(int remainingUses) {this.remainingUses = remainingUses;}




}