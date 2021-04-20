package com.example.vehicletickets

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class Profile : Fragment() {
    val db = Firebase.firestore
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
    lateinit var a:StringBuffer
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // val context = context as MainActivity
        //val centerlist = resources.getStringArray(R.array.profile)



        readFireStoreData()


      /*  val lv = context.findViewById(R.id.profile_list) as ListView
        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, centerlist)
        lv.adapter = adapter*/

        // Create a new user with a first and last name




    }

    fun readFireStoreData(){
        val context = context as MainActivity




        val lv = context.findViewById(R.id.profile_list) as ListView


        val db = FirebaseFirestore.getInstance()
        db.collection("users")
            .get()
            .addOnCompleteListener {

                val result: StringBuffer = StringBuffer()
                val result2: ArrayList<String> = ArrayList()


                if(it.isSuccessful) {
                    for(document in it.result!!) {
                        val name=document.data.getValue("firstName").toString()
                        val name2=document.data.getValue("lastName").toString()
                        val fnamelname = name.plus(" ").plus(name2)

                        result2.add(fnamelname)
                        /*result.append(document.data.getValue("firstName")).append(" ")
                            .append(document.data.getValue("lastName")).append("\n\n")*/
                    }

                }



                val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, result2)
                lv.adapter = adapter

            }

    }
}