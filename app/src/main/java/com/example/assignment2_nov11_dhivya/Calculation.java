package com.example.assignment2_nov11_dhivya;

import java.util.ArrayList;

public class Calculation {
    ArrayList <String> calculateprodlist = new ArrayList<>(0);
    String FirstExp;

    public void push(String value )
    {
        FirstExp = FirstExp +value;
        this.calculateprodlist.add(value);
        System.out.println("Array value"+calculateprodlist);
    }
    public double TotalAmount(double prodqty,double prodprice){
        double Subtotal = prodqty * prodprice;
        return  Subtotal;
    }
    public void clear(){
        calculateprodlist.clear();
    }
}
