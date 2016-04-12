package com.chuckwagon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Created by branden on 4/6/16 at 14:12.
 *
 * This will store the location of all active vendors.
 * there is logic to remove the entry after a set time
 */

@Entity
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "location_id", unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Float lat;

    @Column(nullable = false)
    private Float lng;

    @Column(name = "image_url")
    private String imageUrl;

    private String tweet;

    @Column(nullable = false, name = "expires_object")
    @JsonIgnore
    private LocalDateTime expiresObject;

    @Transient
    private String expiresString;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vendor vendor;



    public Location() {
    }

    public Location(Float lat, Float lng, String expiresString) {
        this.lat = lat;
        this.lng = lng;
        this.expiresString = expiresString;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public LocalDateTime getExpiresObject() {
        return expiresObject;
    }

    public void setExpiresObject(LocalDateTime expiresObject) {
        this.expiresObject = expiresObject;
    }

    public String getExpiresString() {
        return expiresString;
    }

    public void setExpiresString(String expiresString) {
        this.expiresString = expiresString;
      //  this.expiresObject = LocalDateTime.parse(expiresString);
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Integer getId() {
        return id;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", lat=" + lat +
                ", lng=" + lng +
                ", tweet='" + tweet + '\'' +
                ", expiresObject=" + expiresObject +
                ", expiresString='" + expiresString + '\'' +
                ", vendor=" + vendor +
                '}';
    }
}