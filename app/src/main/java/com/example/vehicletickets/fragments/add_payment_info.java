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
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.vehicletickets.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;


public class add_payment_info extends Fragment {
    String arrival = "";
    String arrival_full = "";
    String departure = "";
    String departure_full = "";
    String flight_date= "";
    String flight_number = "";
    String seat = "";
    int money = 0;
    String time = "";

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference documentReference;
    CollectionReference collectionReference;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();




    public add_payment_info() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_payment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton button=view.findViewById(R.id.go_forward);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Map<String,Object> map=new HashMap<>();
                map.put("arrival_path",arrival_full);
                map.put("arrival_path_short",arrival);
                map.put("departure_path",departure_full);
                map.put("departure_path_short",departure);
                map.put("date",flight_date);
                map.put("fligt_number",flight_number);
                map.put("money",money);
                map.put("time",time);
                map.put("seat",seat);
                map.put("mail",firebaseAuth.getCurrentUser().getEmail());

                collectionReference=db.collection("my_flights");
                collectionReference.add(map).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(getContext(),"Successfull!",Toast.LENGTH_SHORT).show();
                    }
                });

                NavDirections action= add_payment_infoDirections.actionAddPaymentİnfoToNewMainActivity();
                Navigation.findNavController(view).navigate(action);



            }
        });
        if (getArguments() != null) {

            arrival = add_payment_infoArgs.fromBundle(getArguments()).getArrival();
            arrival_full = add_payment_infoArgs.fromBundle(getArguments()).getArrivalFull();


            departure = add_payment_infoArgs.fromBundle(getArguments()).getDeparture();
            departure_full = add_payment_infoArgs.fromBundle(getArguments()).getDepartureFull();

            flight_date = add_payment_infoArgs.fromBundle(getArguments()).getFlightDate();
            flight_number = add_payment_infoArgs.fromBundle(getArguments()).getFlightNumber();
            money = add_payment_infoArgs.fromBundle(getArguments()).getMoney();
            time = add_payment_infoArgs.fromBundle(getArguments()).getTime();
            seat=add_payment_infoArgs.fromBundle(getArguments()).getSeatNumber();


        }








    }
}