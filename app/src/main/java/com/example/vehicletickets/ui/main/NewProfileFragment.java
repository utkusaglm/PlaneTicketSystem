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
import android.widget.Toast;

import com.example.vehicletickets.R;
import com.example.vehicletickets.Users;
import com.example.vehicletickets.profileRecyclerAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;


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

    public static NewProfileFragment newInstance(){
        return new NewProfileFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        documentReference=db.collection("users").document(firebaseAuth.getCurrentUser().getEmail());

        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Users users = documentSnapshot.toObject(Users.class);
                Toast.makeText(getActivity(),users.getEmail(),Toast.LENGTH_LONG).show();

                //TO DO DO not make it static.

                namesurname.add(users.getName()+" "+users.getSurname());
                namesurname.add(users.getName()+" "+users.getSurname());
                namesurname.add(users.getName()+" "+users.getSurname());

                story.add("är en utfyllnadstext från tryck- och förlagsindustrin. Lorem ipsum har varit standard ända sedan 1500-talet, när en okänd boksättare tog att antal bokstäver och blandade dem för at");
                story.add("är en utfyllnadstext från tryck- och förlagsindustrin. Lorem ipsum har varit standard ända sedan 1500-talet, när en okänd boksättare tog att antal bokstäver och blandade dem för at");
                story.add("är en utfyllnadstext från tryck- och förlagsindustrin. Lorem ipsum har varit standard ända sedan 1500-talet, när en okänd boksättare tog att antal bokstäver och blandade dem för at");

                //url=new ArrayList<String>(users.getFlights());

                url.add("https://firebasestorage.googleapis.com/v0/b/vehicletickets.appspot.com/o/antalyahavalimani.jpg?alt=media&token=fe3c6db0-f232-4296-8f49-9243dc2a1245");
                url.add("https://firebasestorage.googleapis.com/v0/b/vehicletickets.appspot.com/o/antalyahavalimani.jpg?alt=media&token=fe3c6db0-f232-4296-8f49-9243dc2a1245");
                url.add("https://firebasestorage.googleapis.com/v0/b/vehicletickets.appspot.com/o/antalyahavalimani.jpg?alt=media&token=fe3c6db0-f232-4296-8f49-9243dc2a1245");

                pra.notifyDataSetChanged();
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
        recyclerView = view.findViewById(R.id.profilerecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(pra);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}