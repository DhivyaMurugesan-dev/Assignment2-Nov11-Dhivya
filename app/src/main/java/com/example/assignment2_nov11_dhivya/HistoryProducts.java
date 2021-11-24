package com.example.assignment2_nov11_dhivya;

import com.google.type.Date;
//import.java.util.Date;

public class HistoryProducts extends ProductModel {
    Date Purchasedate ;

    public HistoryProducts(Double price, int qty, String name,Date Purchasedate) {
        super(price, qty, name);
        this.Purchasedate = Purchasedate ;
    }
}
