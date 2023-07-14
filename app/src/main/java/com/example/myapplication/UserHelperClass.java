package com.example.myapplication;

public class UserHelperClass {
    private String name;
    private String address;
    private String donationOption;
    private String amount;

    public UserHelperClass() {
        // Empty constructor needed for Firebase
    }

    public UserHelperClass(String name, String address, String donationOption, String amount) {
        this.name = name;
        this.address = address;
        this.donationOption = donationOption;
        this.amount = amount;
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDonationOption() {
        return donationOption;
    }

    public String getAmount() {
        return amount;
    }
}
