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

public class flight_info_adapter extends RecyclerView.Adapter<flight_info_adapter.PostHolder> {


//    private ArrayList<String> url;
//    private ArrayList<String> namesurname;
//    private ArrayList<String> story;

    private ArrayList<String> departure_locationarr;
    private ArrayList<String> departure_location_fullarr;
    private ArrayList<String> date_locationarr;

    private ArrayList<String> arrival_locationarr;
    private ArrayList<String> arrival_location_fullarr;
    private ArrayList<String> flight_numbersarr;
    private View.OnClickListener mOnClickListener;
    private Context context;


    public flight_info_adapter(ArrayList<String> departure_location, ArrayList<String> departure_location_full, ArrayList<String> date_location, ArrayList<String> arrival_location, ArrayList<String> arrival_location_full, ArrayList<String> flight_numbers,Context context) {

        this.departure_locationarr = departure_location;
        this.departure_location_fullarr = departure_location_full;
        this.date_locationarr = date_location;

        this.arrival_locationarr = arrival_location;
        this.arrival_location_fullarr = arrival_location_full;
        this.flight_numbersarr = flight_numbers;
        this.context = context;
    }


    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.flightrow, parent, false);
        view.setOnClickListener(mOnClickListener);
        return new PostHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.departure_location.setText(departure_locationarr.get(position));
        holder.departure_location_full.setText(departure_location_fullarr.get(position));
        holder.date_location.setText(date_locationarr.get(position));

        holder.arrival_location.setText(arrival_locationarr.get(position));
        holder.arrival_location_full.setText(arrival_location_fullarr.get(position));
        holder.flight_numbers.setText(flight_numbersarr.get(position));

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, flight_info.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return departure_locationarr.size();
    }


    class PostHolder extends RecyclerView.ViewHolder {
        TextView departure_location;
        TextView departure_location_full;
        TextView date_location;

        TextView arrival_location;
        TextView arrival_location_full;
        TextView flight_numbers;



        public PostHolder(@NonNull View itemView) {
            super(itemView);

            departure_location=itemView.findViewById(R.id.departure_location);
            departure_location_full=itemView.findViewById(R.id.departure_location_full);
            date_location=itemView.findViewById(R.id.date_location);

            arrival_location=itemView.findViewById(R.id.arrival_location);
            arrival_location_full=itemView.findViewById(R.id.departure_location_full);
            flight_numbers=itemView.findViewById(R.id.flight_numbers);

        }
    }


}
