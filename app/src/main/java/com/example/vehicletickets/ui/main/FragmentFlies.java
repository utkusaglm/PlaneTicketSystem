package com.example.vehicletickets.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vehicletickets.R;
import com.example.vehicletickets.profileRecyclerAdapter;

public class FragmentFlies extends Fragment {



    public static FragmentFlies newInstance() {
        return new FragmentFlies();
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
       return inflater.inflate(R.layout.profile_informations, container, false);
       /* LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        View view=layoutInflater.inflate(R.layout.profilelayoutrow,parent,false);
        return new profileRecyclerAdapter.PostHolder(view);*/
    }
}
