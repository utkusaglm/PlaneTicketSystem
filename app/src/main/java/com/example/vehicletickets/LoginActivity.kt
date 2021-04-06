package com.example.vehicletickets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth
        emailEditText=findViewById(R.id.maillogintextView) as EditText
        passwordEditText=findViewById(R.id.passlogintextView2) as EditText

    }

    fun login(view: View) {
        var email=emailEditText.text.toString()
        var password=passwordEditText.text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val user = auth.currentUser
                    val intent = Intent(this, MainActivity::class.java).apply {

                    }

                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(baseContext, task.exception.toString(),
                        Toast.LENGTH_SHORT).show()

                }
            }




    }
    fun gotoregister(view: View) {
        val intent = Intent(this, RegisterActivity::class.java).apply {

        }
        startActivity(intent)

    }
}