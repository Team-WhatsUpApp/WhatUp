package com.whatsup.model;

import com.whatsup.model.User;

import javax.persistence.*;

/**
 * Created by mosesfranco on 7/5/17
 * Codeup
 * Pinnacles
 */

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private User owner;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "validated")
    private boolean isValidated;

    public Vendor(User owner, String displayName) {
        this.owner = owner;
        this.displayName = displayName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }
}