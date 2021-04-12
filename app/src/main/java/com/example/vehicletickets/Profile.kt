package com.example.vehicletickets
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
class Profile : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = context as MainActivity
        val centerlist = resources.getStringArray(R.array.profile)

        val lv = context.findViewById(R.id.profile_list) as ListView
        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, centerlist)
        lv.adapter = adapter
    }
}