package com.example.vehicletickets.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vehicletickets.R;
import com.example.vehicletickets.flight_info;

import java.util.ArrayList;

public class date_adapter extends RecyclerView.Adapter<date_adapter.PostHolder>  {

    private ArrayList<String> date_textarr;
    private ArrayList<String> number_date_textarr;
    private View.OnClickListener mOnClickListener;
    private Context context;





    public date_adapter(ArrayList<String> date_text, ArrayList<String> number_date_text ,Context context) {
        this.date_textarr=date_text;
        this.number_date_textarr=number_date_text;
        this.context = context;
    }




    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.daterow, parent, false);
        view.setOnClickListener(mOnClickListener);
        return new date_adapter.PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.date_text.setText(date_textarr.get(position));
        holder.number_date_text.setText(number_date_textarr.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    @Override
    public int getItemCount() {
        return date_textarr.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        TextView date_text;
        TextView number_date_text;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            date_text=itemView.findViewById(R.id.day_text);
            number_date_text=itemView.findViewById(R.id.number_day_text);
        }
    }
}
