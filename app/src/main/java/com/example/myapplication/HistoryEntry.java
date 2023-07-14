package com.example.myapplication;

public class HistoryEntry {

    String yourName;
    String nakshatra;
    String rashi;
    String selectedOption;
    String selectedDate;

    String poojaname, price;

    public HistoryEntry( String yourName, String nakshatra, String rashi, String selectedOption, String selectedDate, String poojaname, String price ) {
        this.yourName = yourName;
        this.nakshatra = nakshatra;
        this.rashi = rashi;
        this.selectedOption = selectedOption;
        this.selectedDate = selectedDate;
        this.poojaname = poojaname;
        this.price = price;
    }


    public String getYourName() {

        return yourName;
    }

    public void setYourName(String yourName) {

        this.yourName = yourName;
    }

    public String getNakshatra() {
        return nakshatra;
    }

    public void setNakshatra(String nakshatra) {
        this.nakshatra = nakshatra;
    }

    public String getRashi() {
        return rashi;
    }

    public void setRashi(String rashi) {
        this.rashi = rashi;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public String getPoojaname() {
        return poojaname;
    }

    public String getPrice() {
        return price;
    }

    public void setPoojaname(String poojaname) {
        this.poojaname = poojaname;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}