package com.example.assignment2_nov11_dhivya;

import android.os.Parcel;
import android.os.Parcelable;

//Trying to build the product model class with prodprice,prodqty,prodname
public class ProductModel {
    Double ProdPrice;
    int ProdQty;
    String ProdName;
// Creating Constructor of ProductModel class
  public ProductModel(Double price,int qty,String name) {
     this.ProdPrice = price;
     this.ProdQty = qty;
     this.ProdName = name;
    }
//Getting and setting the values
    public Double getProdPrice(){
     return ProdPrice;
    }
    public void setProdPrice(Double price){
        this.ProdPrice = price;
    }
    public int getProdQty(){
        return ProdQty;
    }
    public void setProdQty(int qty){
        this.ProdQty = qty;
    }
    public String getProdName(){
        return ProdName;
    }
    public void setProdName(String name){
        this.ProdName = name;
    }
    //Gives the displays to the object
   /* @Override
    public String toString(){
      return "Product[ProdType=" +ProdName+ ",Prodqty="+ProdQty+",ProdPrice="+ProdPrice+"]";
    }*/

    protected  ProductModel(Parcel in){
        ProdName = in.readString();
        ProdQty = in.readInt();
        ProdPrice = in.readDouble();
    }
    public static final Parcelable.Creator<ProductModel> CREATOR= new Parcelable.Creator<ProductModel>() {
        @Override
        public ProductModel createFromParcel(Parcel source) {
            return new ProductModel(source);
        }

        @Override
        public ProductModel[] newArray(int size) {
            return new ProductModel[size];
        }
    };
    public void setQnt(int qty){
        this.ProdQty = qty;
    }
      // @Override
    public int describeContents() {
        return 0;
    }

    protected void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(ProdPrice);
        dest.writeInt(ProdQty);
        dest.writeString(ProdName);
    }
}