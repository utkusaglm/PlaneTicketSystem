package com.example.vehicletickets.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vehicletickets.R;
import com.example.vehicletickets.adapter.date_adapter;
import com.example.vehicletickets.adapter.flight_info_adapter;
import com.example.vehicletickets.adapter.profileRecyclerAdapter;

import java.util.ArrayList;

public class add_select_flight_fragment extends Fragment {

    com.example.vehicletickets.adapter.date_adapter date_adapter;
    RecyclerView recyclerView;

    com.example.vehicletickets.adapter.flight_info_adapter fligh_adapter;
    RecyclerView recyclerView2;

    ArrayList<String> date_textarr= new ArrayList<>();
    ArrayList<String> number_date_textarr=new ArrayList<>();

    ArrayList<String> departure_locationarr = new ArrayList<>();
    ArrayList<String> departure_location_fullarr = new ArrayList<>();
    ArrayList<String> date_locationarr = new ArrayList<>();

    ArrayList<String> arrival_locationarr = new ArrayList<>();
    ArrayList<String> arrival_location_fullarr = new ArrayList<>();
    ArrayList<String> flight_numbersarr = new ArrayList<>();



    public add_select_flight_fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        date_textarr.add("FRI");
        date_textarr.add("FRI");
        date_textarr.add("FRI");
        date_textarr.add("FRI");
        date_textarr.add("FRI");
        date_textarr.add("FRI");
        date_textarr.add("FRI");
        date_textarr.add("FRI");
        date_textarr.add("FRI");
        date_textarr.add("FRI");

        number_date_textarr.add("12");
        number_date_textarr.add("12");
        number_date_textarr.add("12");
        number_date_textarr.add("12");
        number_date_textarr.add("12");
        number_date_textarr.add("12");
        number_date_textarr.add("12");
        number_date_textarr.add("12");
        number_date_textarr.add("12");
        number_date_textarr.add("12");

        departure_locationarr.add("att");
        departure_location_fullarr.add("attargah");
        date_locationarr.add("01.04.2020");

        arrival_locationarr.add("arrr");
        arrival_location_fullarr.add("arriab");
        flight_numbersarr.add("05.09.202");

        departure_locationarr.add("att");
        departure_location_fullarr.add("attargah");
        date_locationarr.add("01.04.2020");

        arrival_locationarr.add("arrr");
        arrival_location_fullarr.add("arriab");
        flight_numbersarr.add("05.09.202");

        fligh_adapter = new flight_info_adapter(departure_locationarr, departure_location_fullarr, date_locationarr, arrival_locationarr, arrival_location_fullarr, flight_numbersarr,getContext());

        date_adapter = new date_adapter(date_textarr,number_date_textarr,getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_select_flight_fragment, container, false);
//        new_res = view.findViewById(R.id.button_res);

        recyclerView = view.findViewById(R.id.date_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(date_adapter);

        recyclerView2 = view.findViewById(R.id.all_flight_info_recycler_view);
        recyclerView2.setHasFixedSize(true);
        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(fligh_adapter);













//        new_res.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), FlightSearch.class);
//                startActivity(intent);
//            }
//        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}