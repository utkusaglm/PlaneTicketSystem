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
import com.google.firebase.ktx.Firebase


class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var mailTextView: EditText
    private lateinit var passTextView:EditText
    private lateinit var passAgainTextView:EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mailTextView = findViewById(R.id.mailtextView) as EditText
        passTextView = findViewById(R.id.passtextView2) as EditText
        passAgainTextView= findViewById(R.id.passagaintextView3) as EditText
        auth = Firebase.auth
    }

    fun register(view: View) {

        val email: String = mailTextView.text.toString()
        val password: String = passTextView.text.toString()
        val passwordtrue: String = passAgainTextView.text.toString()

        if(password.equals(passwordtrue)){
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information

                        val user = auth.currentUser
                        Toast.makeText(baseContext, "Succesfull!",
                            Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java).apply {

                        }

                        startActivity(intent)

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, task.exception.toString(),
                            Toast.LENGTH_SHORT).show()


                    }
                }

        }else{

        }





    }
}