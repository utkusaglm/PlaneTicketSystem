package com.example.vehicletickets;

public class CreditCard {

    private String nameAndSurname;
    private long creditCardNumber ;
    private long creditCardstt;
    private long cvv;

    public CreditCard(String nameAndSurname, long creditCardNumber, long creditCardstt, long cvv) {
        this.nameAndSurname = nameAndSurname;
        this.creditCardNumber = creditCardNumber;
        this.creditCardstt = creditCardstt;
        this.cvv = cvv;
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public long getCreditCardstt() {
        return creditCardstt;
    }

    public void setCreditCardstt(long creditCardstt) {
        this.creditCardstt = creditCardstt;
    }

    public long getCvv() {
        return cvv;
    }

    public void setCvv(long cvv) {
        this.cvv = cvv;
    }
}
