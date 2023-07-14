package com.example.myapplication;

public class DataObject {
     String email;
     String yourName;
     String nakshatra;
     String rashi;
     String selectedOption;
     String selectedDate;

     String Poojaname, Price;

    public DataObject() {
        // Default constructor required for Firebase database
    }

    public DataObject(String email,String yourName, String nakshatra, String rashi, String selectedOption, String selectedDate,  String Price, String Poojaname) {
        this.yourName = yourName;
        this.email = email;
        this.nakshatra = nakshatra;
        this.rashi = rashi;
        this.selectedOption = selectedOption;
        this.selectedDate = selectedDate;
        this.Poojaname = Poojaname;
        this.Price = Price;
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
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPoojaname() {
        return Poojaname;
    }

    public String getPrice() {
        return Price;
    }

    public void setPoojaname(String poojaname) {
        Poojaname = poojaname;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
