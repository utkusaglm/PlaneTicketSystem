package com.example.vehicletickets.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.vehicletickets.R;


public class add_seat_fragment extends Fragment {


    public add_seat_fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_seat_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button=view.findViewById(R.id.buttons);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  NavDirections action= add_seat_fragmentDirections.actionAddSeatFragmentToAddFlightFragment();
                //Navigation.findNavController(view).navigate(action);

            }
        });
    }
}