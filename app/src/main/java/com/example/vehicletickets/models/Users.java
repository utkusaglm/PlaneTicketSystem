package com.example.vehicletickets.models;

import java.util.ArrayList;
import java.util.LinkedList;

public class Users{
    private int bonus;
    private String country;
    private String creditCardInfo;
    private String email;
    private ArrayList<String> flights;
    private String name;
    private String surname;
    private int numberOfFlies;
    private int wallet;

    public Users() {
    }

    public Users(int bonus, String country, String email, ArrayList<String> flights, String name, String surname, int numberOfFlies, int wallet) {
        this.bonus = bonus;
        this.country = country;
        this.email = email;
        this.flights = flights;
        this.name = name;
        this.surname = surname;
        this.numberOfFlies = numberOfFlies;
        this.wallet = wallet;
    }

    public Users(int bonus, String country, String creditCardInfo, String email, ArrayList<String> flights, String name, String surname, int numberOfFlies) {
        this.bonus = bonus;
        this.country = country;
        this.creditCardInfo = creditCardInfo;
        this.email = email;
        this.flights = flights;
        this.name = name;
        this.surname = surname;
        this.numberOfFlies = numberOfFlies;
    }

    public Users(int bonus, String country, String email,  ArrayList<String> flights, String name, String surname, int numberOfFlies) {
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

    public ArrayList<String> getFlights() {
        return flights;
    }

    public void setFlights( ArrayList<String> flights) {
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

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
}
