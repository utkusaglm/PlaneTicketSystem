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
import android.widget.Button;
import android.widget.Toast;

import com.example.vehicletickets.FlightSearch;
import com.example.vehicletickets.R;
import com.example.vehicletickets.models.Users;

import com.example.vehicletickets.profileRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;


public class NewProfileFragment extends Fragment {

    PageViewModel pageViewModel;


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference documentReference;
    FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();

    ArrayList<String> url=new ArrayList<>();
    ArrayList<String> namesurname= new ArrayList<>();
    ArrayList<String> story= new ArrayList<>();
    profileRecyclerAdapter pra;
    RecyclerView recyclerView;

    Button new_res;

    public static NewProfileFragment newInstance(){
        return new NewProfileFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        documentReference=db.collection("users").document(firebaseAuth.getCurrentUser().getEmail());
        DocumentReference documentReferenceforcities = db.collection("cities").document("cities");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Users users = documentSnapshot.toObject(Users.class);

                //TO DO DO not make it static.
                ArrayList<String> listOfFlights=users.getFlights();

                for(String a:listOfFlights){
                    namesurname.add(users.getName()+" "+users.getSurname());
                    documentReferenceforcities.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            Map<String, Object> map  = (Map<String, Object>) documentSnapshot.get(a);
                            if (map != null) {
                                story.add((String)map.get("story"));
                                url.add((String)map.get("link"));
                                System.out.println(((String)map.get("link")));
                                System.out.println(((String)map.get("story")));
                                pra.notifyDataSetChanged();

                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getContext(),e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });


                }

//                  pra.notifyDataSetChanged();


//
//                story.add("är en utfyllnadstext från tryck- och förlagsindustrin. Lorem ipsum har varit standard ända sedan 1500-talet, när en okänd boksättare tog att antal bokstäver och blandade dem för at");
//                story.add("är en utfyllnadstext från tryck- och förlagsindustrin. Lorem ipsum har varit standard ända sedan 1500-talet, när en okänd boksättare tog att antal bokstäver och blandade dem för at");
//                story.add("är en utfyllnadstext från tryck- och förlagsindustrin. Lorem ipsum har varit standard ända sedan 1500-talet, när en okänd boksättare tog att antal bokstäver och blandade dem för at");
//
//                //url=new ArrayList<String>(users.getFlights());
//
//                url.add("https://firebasestorage.googleapis.com/v0/b/vehicletickets.appspot.com/o/antalyahavalimani.jpg?alt=media&token=fe3c6db0-f232-4296-8f49-9243dc2a1245");
//                url.add("https://firebasestorage.googleapis.com/v0/b/vehicletickets.appspot.com/o/antalyahavalimani.jpg?alt=media&token=fe3c6db0-f232-4296-8f49-9243dc2a1245");
//                url.add("https://firebasestorage.googleapis.com/v0/b/vehicletickets.appspot.com/o/antalyahavalimani.jpg?alt=media&token=fe3c6db0-f232-4296-8f49-9243dc2a1245");


            }
        });
        pra=new profileRecyclerAdapter(url,namesurname,story);


        pageViewModel= new ViewModelProvider(requireActivity()).get(PageViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_new_profile, container, false);
        new_res=view.findViewById(R.id.button_res);
        recyclerView = view.findViewById(R.id.profilerecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(pra);



        new_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), FlightSearch.class);
                startActivity(intent);
            }
        });



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}