package com.example.salaizy.listviewbasic;

/**
 * Created by salaizy on 3/22/2018.
 */

public class AdapterItems {
    public   int ID;
    public  String JobTitle;
    public  String Description;
    public  int img;
    //for news details
    AdapterItems( int ID, int img, String JobTitle,String Description)
    {
        this. ID=ID;
        this. JobTitle=JobTitle;
        this. Description=Description;
        this.img = img;
    }
}
