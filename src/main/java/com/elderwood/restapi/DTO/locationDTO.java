package com.elderwood.restapi.DTO;

public class locationDTO {

    private String loc_name;
    private String address;

    
    public locationDTO() {
    }

    public locationDTO(String loc_name, String address) {
        this.loc_name = loc_name;
        this.address = address;
    }

    public String getLoc_name() {
        return loc_name;
    }
    public void setLoc_name(String loc_name) {
        this.loc_name = loc_name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    
}

