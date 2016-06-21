package com.example.kelvin.wheretoeat;

/**
 * Created by Kelvin on 2016/6/22.
 */
public class Shop {
    protected String name;
    protected String address;
    protected String phone;
    //protected String[] dish;
    //protected int[] price;
    //protected int imageId;

    public Shop(){}

    public Shop(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public String getPhone(){
        return this.phone;
    }
}
