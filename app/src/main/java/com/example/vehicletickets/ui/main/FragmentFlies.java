package com.example.vehicletickets.ui.main;

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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vehicletickets.R;
import com.example.vehicletickets.models.Users;
import com.example.vehicletickets.profileRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class FragmentFlies extends Fragment {
    PageViewModel pageViewModel;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference documentReference;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    int bonus=0;
    String country="";
    String email="";
    ArrayList<String> flights=new ArrayList<>();
    String name="";
    int numberOfFlies;
    String surname="";
    int wallet=0;


    TextView nameTextView;
    TextView locationTextView;
    TextView flightNTextView;
    TextView creditTextView;
    TextView bonusTextView;
    Button button;


    public static FragmentFlies newInstance() {
        return new FragmentFlies();
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        documentReference=db.collection("users").document(firebaseAuth.getCurrentUser().getEmail());
//        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                Users users = documentSnapshot.toObject(Users.class);
//                bonus=users.getBonus();
//                country=users.getCountry();
//                email=users.getEmail();
//                flights=users.getFlights();
//                name=users.getName();
//                numberOfFlies=users.getNumberOfFlies();
//                surname=users.getSurname();
//                wallet=users.getWallet();
//                System.out.println(bonus+"aaa");
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(getContext(),e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
//            }
//        });
//        pageViewModel= new ViewModelProvider(requireActivity()).get(PageViewModel.class);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.profile_informations, container, false);
        View view= inflater.inflate(R.layout.profile_informations, container, false);
        nameTextView=view.findViewById(R.id.UserName);
        locationTextView=view.findViewById(R.id.location);
        flightNTextView=view.findViewById(R.id.flight_numbers);
        creditTextView=view.findViewById(R.id.credit);
        bonusTextView=view.findViewById(R.id.bonus_numbers);
        button=view.findViewById(R.id.add_credit);


        documentReference=db.collection("users").document(firebaseAuth.getCurrentUser().getEmail());
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Users users = documentSnapshot.toObject(Users.class);
                bonus=users.getBonus();
                country=users.getCountry();
                email=users.getEmail();
                flights=users.getFlights();
                name=users.getName();
                numberOfFlies=users.getNumberOfFlies();
                surname=users.getSurname();
                wallet=users.getWallet();
                System.out.println(bonus+"aaa");
                System.out.println(name+"aaa");
                System.out.println(country);
                System.out.println(numberOfFlies);
                System.out.println(wallet);
                nameTextView.setText(name+" "+surname);
                locationTextView.setText(country);
                flightNTextView.setText(String.valueOf(numberOfFlies));
                creditTextView.setText(String.valueOf(wallet));
                bonusTextView.setText(String.valueOf(bonus));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(),e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        pageViewModel= new ViewModelProvider(requireActivity()).get(PageViewModel.class);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"payment",Toast.LENGTH_SHORT).show();
            }
        });



        return view;


//        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
//        View view=layoutInflater.inflate(R.layout.profilelayoutrow,parent,false);
//        return new profileRecyclerAdapter.PostHolder(view);
    }
}
