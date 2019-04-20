package com.example.silver_tech.donatelife.Activities;

class Donors {
    private String donorId;
    private String donorName;
    private String donorGender;
    private String donorPhone;
    private String donorDob;
    private String donorOrgan;
    private String donorCounty;
    private String donorBlood;

    public Donors() {
        //this constructor is required
    }

    public Donors(String donorId,String donorName,String donorGender,String donorPhone,String donorDob,String donorOrgan,String donorCounty,String donorBlood) {
        this.donorId = donorId;
        this.donorCounty = donorCounty;
        this.donorOrgan = donorOrgan;

        this.donorGender = donorGender;
        this.donorDob = donorDob;
        this.donorPhone = donorPhone;
        this.donorName = donorName;
        this.donorBlood = donorBlood;
    }

    public String getDonorId() {
        return donorId;
    }

    public String getDonorName() {
        return donorName;
    }

    public String getDonorGender() {
        return donorGender;
    }

    public String getDonorPhone() {
        return donorPhone;
    }

    public String getDonorDob() {
        return donorDob;
    }

    public String getDonorOrgan() {
        return donorOrgan;
    }

    public String getDonorCounty() {
        return donorCounty;
    }

    public String getDonorBlood() {
        return donorBlood;
    }
}

