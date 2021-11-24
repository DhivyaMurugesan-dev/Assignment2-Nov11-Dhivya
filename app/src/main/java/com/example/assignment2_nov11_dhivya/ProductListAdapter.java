package com.example.assignment2_nov11_dhivya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends BaseAdapter {
    private static final String TAG = "ProductListAdapter";
    int position;
    private Context myContext;

    //When you use a custom view in a ListView you must define the row layout
    //private List<ProductModel> Productlist = new ArrayList<>();
    private List<ProductModel> Productlist;

    //Layout Inflater is used to inflate(create) a view
     private LayoutInflater prodInflater;


    //public constructor
    public ProductListAdapter(Context myContext, List Productlist) {
        this.myContext = myContext;
        this.Productlist = Productlist;
        prodInflater = (LayoutInflater.from(myContext));
    }


//    public ProductListAdapter(Context mycontext, ListView productlist) {
//        this.context = applicationContext;
//        mInflater = (LayoutInflater.from(applicationContext));
//    }


    // public ProductListAdapter(@NonNull Context context, int resource, @NonNull ProductModel[] objects) {

//      public ProductListAdapter(@NonNull Context context, @LayoutRes ListView Productlist) {
//
//          super(context, 0, list);
//        mContext = context;
//        Productlist = list;
//    }
//public class CustomAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return Productlist.size();
    }//returns the total number of products in the list

    @Override
    public Object getItem(int position) {
        return Productlist.get(position);//return list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        {
            // inflate the layout for each list row
            if (convertView == null) {
                convertView = LayoutInflater.from(myContext).
                        inflate(R.layout.activity_productlist, parent, false);
                TextView name = (TextView )convertView.findViewById(R.id.listprodname);
                TextView price= (TextView )convertView.findViewById(R.id.listprodprice);
                TextView qty= (TextView )convertView.findViewById(R.id.listprodqty);

               name.setText(Productlist.get(position).ProdName);
               qty.setText(Productlist.get(position).ProdQty+"");
               price.setText(Productlist.get(position).ProdPrice+"");
               return convertView;
            }

            // get current item to be displayed
            ProductModel currentItem = (ProductModel) getItem(position);

            // get the TextView for product name,qty and price
            TextView ProdName = (TextView)
                    convertView.findViewById(R.id.listprodname);
            TextView  ProdPrice = (TextView)
                    convertView.findViewById(R.id.listprodprice);
            TextView ProdQty = (TextView)
                    convertView.findViewById(R.id.listprodqty);

            //sets the text for item name and item description from the current item object
            ProdName.setText(Productlist.get(position).ProdName);
            ProdPrice.setText(Productlist.get(position).ProdPrice+"");
            ProdQty.setText(Productlist.get(position).ProdQty+"");
        //    listprodprice.setText(currentItem.getProdPrice());
        //    listprodqty.setText(currentItem.getProdQty());

            // returns the view for the current row
            return convertView;
        }
    }
}
    //    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//       view = mInflater.inflate(R.layout.activity_productlist,null);
//        return view;
//    }
//@Override
//public View getView(int position, View convertView, ViewGroup container) {
//    if (convertView == null) {
//        convertView = getLayoutInflater().inflate(R.layout.list_item, container, false);
//    }
//
//    ((TextView) convertView.findViewById(android.R.id.text1))
//            .setText(getItem(position));
//    return convertView;
//   }
//  }
