package com.example.vehicletickets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

private lateinit var auth: FirebaseAuth
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            Toast.makeText(applicationContext,"You can LogOut", Toast.LENGTH_SHORT).show()
        }else{
            val intent = Intent(this, RegisterActivity::class.java).apply {

            }
            Toast.makeText(applicationContext,"You need to register", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }


    }

    fun logout(view: View) {
        val intent = Intent(this, LoginActivity::class.java).apply {

        }

        startActivity(intent)
    }
}