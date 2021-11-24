package com.example.assignment2_nov11_dhivya;

import java.util.ArrayList;

public class StoreManager {
    public ArrayList<ProductModel> arrproductlist;

    StoreManager() {
        //Creating objects of the Product Model class
        this.arrproductlist = new ArrayList<>(4);

        ProductModel prodmod1 = new ProductModel(20.44, 10, "Pants");
        ProductModel prodmod2 = new ProductModel(50.20, 20, "Shirts");
        ProductModel prodmod3 = new ProductModel(10.44, 5, "Hats");
        ProductModel prodmod4 = new ProductModel(30.04, 25, "Shoes");


        arrproductlist.add(prodmod1);
        arrproductlist.add(prodmod2);
        arrproductlist.add(prodmod3);
        arrproductlist.add(prodmod4);
    }
}
