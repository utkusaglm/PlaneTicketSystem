package com.example.vehicletickets.ui.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.vehicletickets.FlightSearch;
import com.example.vehicletickets.R;
import com.example.vehicletickets.models.Users;

import com.example.vehicletickets.adapter.profileRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class NewProfileFragment extends Fragment {

    PageViewModel pageViewModel;


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference documentReference;
    CollectionReference collectionReference;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

//    ArrayList<String> url = new ArrayList<>();
//    ArrayList<String> namesurname = new ArrayList<>();
//    ArrayList<String> story = new ArrayList<>();

    ArrayList<String> departure_locationarr = new ArrayList<>();
    ArrayList<String> departure_location_fullarr = new ArrayList<>();
    ArrayList<String> date_locationarr = new ArrayList<>();

    ArrayList<String> arrival_locationarr = new ArrayList<>();
    ArrayList<String> arrival_location_fullarr = new ArrayList<>();
    ArrayList<String> flight_numbersarr = new ArrayList<>();

    ArrayList<String> timearr= new ArrayList<>();
    ArrayList<String> seatarr= new ArrayList<>();
    ArrayList<String> money= new ArrayList<>();

    profileRecyclerAdapter pra;
    RecyclerView recyclerView;

    ImageButton new_res;

    public static NewProfileFragment newInstance() {
        return new NewProfileFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        pra = new profileRecyclerAdapter(departure_locationarr, departure_location_fullarr, date_locationarr, arrival_locationarr, arrival_location_fullarr, flight_numbersarr,timearr,seatarr,money,getContext());


        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_new_profile, container, false);
        new_res = view.findViewById(R.id.button_res);
        recyclerView = view.findViewById(R.id.profilerecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(pra);


        new_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FlightSearch.class);
                startActivity(intent);
            }
        });


        return view;
    }





    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        collectionReference=db.collection("my_flights");

        collectionReference
                .whereEqualTo("mail",firebaseAuth.getCurrentUser().getEmail())
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        departure_locationarr.add(document.getString("departure_path_short"));
                        departure_location_fullarr.add(document.getString("departure_path"));
                        date_locationarr.add(document.getString("date"));
                        arrival_locationarr.add(document.getString("arrival_path_short"));
                        arrival_location_fullarr.add(document.getString("arrival_path"));
                        flight_numbersarr.add(document.getString("fligt_number"));
                        timearr.add(document.getString("time"));
                        seatarr.add(document.getString("seat"));
                        money.add(document.get("money").toString());



                    }
                } else {
                }
                pra.notifyDataSetChanged();

            }
        });


    }
}