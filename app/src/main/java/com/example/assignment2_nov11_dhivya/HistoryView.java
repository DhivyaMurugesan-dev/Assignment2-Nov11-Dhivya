package com.example.assignment2_nov11_dhivya;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryView extends RecyclerView.Adapter<HistoryView.viewHolder>{
    Context context;
    ArrayList<HistoryModel> allHistory;
    int position =0;

    public interface OnItemClickListener{
        void onItemClick( HistoryModel selectedHistoryItem);
    }

    public HistoryView.OnItemClickListener listener;
    LayoutInflater inflater;


    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView purchasedetail;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            purchasedetail = (TextView)itemView.findViewById(R.id.purchasedetail );
        }
    }


    HistoryView(Context c, ArrayList<HistoryModel> listOfHistory,OnItemClickListener listener){
        context = c;
        allHistory = listOfHistory;
        this.listener = listener;
    }

    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_listofpurchases,parent,false);
        return new HistoryView.viewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull HistoryView.viewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.purchasedetail.setText(allHistory.get(position).ProdName);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(allHistory.get(position));
            }
//            } {
//                @Override
//                public void onItemClick(View view) {
//
//                }
        });
    }
    @Override
    public int getItemCount() {
        return allHistory.size();// 30
    }
}





