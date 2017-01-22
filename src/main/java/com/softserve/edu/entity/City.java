package com.softserve.edu.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="city")
    Set<Hotel> hotels = new HashSet<>();
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="city")
    Set<Tour> tours = new HashSet<>();
    
    @Column(name = "name")
    private String name;

    public City() {
    }

    public City(String name, Country country) {
        this.country = country;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Set<Tour> getTours() {
        return tours;
    }

    public void setTours(Set<Tour> tours) {
        this.tours = tours;
    }
    
    
    
    
}
