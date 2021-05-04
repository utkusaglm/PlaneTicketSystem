package com.example.vehicletickets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var mailEditView: EditText
    private lateinit var passEditView: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mailEditView = findViewById(R.id.MailRegister) as EditText
        passEditView = findViewById(R.id.PasswordRegister) as EditText
        auth = Firebase.auth
    }

    fun signin(view: View) {

        val email: String = mailEditView.text.toString()
        val password: String = passEditView.text.toString()

        auth.signInWithEmailAndPassword(email, password)
           .addOnCompleteListener(this) { task ->
               if (task.isSuccessful) {
                   // Sign in success, update UI with the signed-in user's information

                   val user = auth.currentUser
                   val intent = Intent(this, NewMainActivity::class.java).apply {

                   }
                   startActivity(intent)

               } else {
                   // If sign in fails, display a message to the user.

                   Toast.makeText(
                       baseContext, task.exception.toString(),
                       Toast.LENGTH_SHORT
                   ).show()

               }
           }


    }


}