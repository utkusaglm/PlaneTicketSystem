package com.example.vehicletickets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SeeFlights extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference documentReference;
    FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_flights);
        documentReference=db.collection("flights").document("flights");
//        Map<String, Object> map  = (Map<String, Object>);
//        map.put()

    }
}