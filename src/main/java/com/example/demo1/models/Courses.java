package com.example.demo1.models;

public class Courses {
    private String name;
    private String price;
    private String period_education;
    private String curator;

    public Courses(String name, String price, String period_education, String curator) {
        this.name = name;
        this.price = price;
        this.period_education = period_education;
        this.curator = curator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPeriod_education() {
        return period_education;
    }

    public void setPeriod_education(String period_education) {
        this.period_education = period_education;
    }

    public String getCurator() {
        return curator;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }
}
