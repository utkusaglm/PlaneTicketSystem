package com.example.vehicletickets.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vehicletickets.R;
import com.example.vehicletickets.models.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
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

public class FragmentFlies extends Fragment {
    PageViewModel pageViewModel;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference documentReference;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    CollectionReference collectionReference;

    int bonus = 0;
    String country = "";
    String email = "";
    ArrayList<String> flights = new ArrayList<>();
    String name = "";
    int numberOfFlies;
    String surname = "";
    int wallet = 0;


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
        nameTextView = view.findViewById(R.id.UserName);
        flightNTextView = view.findViewById(R.id.wallet);
        documentReference = db.collection("users").document(firebaseAuth.getCurrentUser().getEmail());
        collectionReference = db.collection("my_flights");
        collectionReference
                .whereEqualTo("mail",firebaseAuth.getCurrentUser().getEmail())
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                int n=0;
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        n+=1;
                        System.out.println("ab");
                        flightNTextView.setText(String.valueOf(n));
                    }
                } else {

                }
            }
        });


        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String a="";
                        a+=document.getString("name");
                        a+=" ";
                        a+=document.getString("surname");
                        nameTextView.setText(a);
                    } else {
                    }
                } else {
                }
            }
        });



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.profile_informations, container, false);
        View view = inflater.inflate(R.layout.profile_informations, container, false);


        return view;

    }
}
