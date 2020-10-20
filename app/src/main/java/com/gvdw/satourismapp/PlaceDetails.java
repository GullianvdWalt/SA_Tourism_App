package com.gvdw.satourismapp;

/*
 Pearson Pretoria BSC IT Level 3
 2020 ITJA321 - Take Home Assessment Question 6
 Gullian Van Der Walt - H5G8YT7X3
 */

public class PlaceDetails {
  // Variables
  private int id;
  private String province;
  private String place;

  // NoArgs Constructor
  public PlaceDetails() {
  }
  // AllArgs Constructor
  public PlaceDetails(int id, String province, String place) {
    this.id = id;
    this.province = province;
    this.place = place;
  }

  // Getter and Setter Methods

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }
}
