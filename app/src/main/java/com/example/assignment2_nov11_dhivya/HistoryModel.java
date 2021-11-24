package com.example.assignment2_nov11_dhivya;

import android.os.Parcel;
import android.os.Parcelable;


    public class HistoryModel extends ProductModel implements Parcelable {
        String purchaseDate;

        public HistoryModel(int qty, double price,String name, String purchaseDate) {
            super( price,qty,name);
            this.purchaseDate = purchaseDate;
        }
        protected  HistoryModel(Parcel in){
            super(in);

            this.purchaseDate = in.readString();

        }
        public static final Creator<HistoryModel> CREATOR= new Creator<HistoryModel>() {
            @Override
            public HistoryModel createFromParcel(Parcel source) {
                return new HistoryModel(source);
            }
            @Override
            public HistoryModel[] newArray(int size) {
                return new HistoryModel[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest,flags);
            dest.writeString(purchaseDate);

        }
    }

