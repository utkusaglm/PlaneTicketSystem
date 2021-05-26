package com.example.vehicletickets.models;

import java.util.LinkedList;
import java.util.Stack;

class cities {
    private String url;
    private String name;

    public cities() {
    }

    public cities(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class users{
    private int bonus;
    private String country;
    private String creditCardInfo;
    private String email;
    private LinkedList<String> flights;
    private String name;
    private String surname;
    private int numberOfFlies;

    public users() {
    }

    public users(int bonus, String country, String creditCardInfo, String email,  LinkedList<String> flights, String name, String surname, int numberOfFlies) {
        this.bonus = bonus;
        this.country = country;
        this.creditCardInfo = creditCardInfo;
        this.email = email;
        this.flights = flights;
        this.name = name;
        this.surname = surname;
        this.numberOfFlies = numberOfFlies;
    }

    public users(int bonus, String country, String email,  LinkedList<String> flights, String name, String surname, int numberOfFlies) {
        this.bonus = bonus;
        this.country = country;
        this.email = email;
        this.flights = flights;
        this.name = name;
        this.surname = surname;
        this.numberOfFlies = numberOfFlies;
    }


    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(String creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LinkedList<String> getFlights() {
        return flights;
    }

    public void setFlights( LinkedList<String> flights) {
        this.flights = flights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNumberOfFlies() {
        return numberOfFlies;
    }

    public void setNumberOfFlies(int numberOfFlies) {
        this.numberOfFlies = numberOfFlies;
    }

}


