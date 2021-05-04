package com.example.vehicletickets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var passwordAgainEditText: EditText
    private lateinit var nameAndSurname: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth
        emailEditText = findViewById(R.id.MailLogin) as EditText
        passwordEditText = findViewById(R.id.PasswordLogin) as EditText
        passwordAgainEditText = findViewById(R.id.PasswordAgainLogin) as EditText
        nameAndSurname = findViewById(R.id.NameSurnameLogin) as EditText


        ///if user already login
        /*if(auth.currentUser!=null){
            val user = auth.currentUser
            val intent = Intent(this, MainActivity::class.java).apply {


            }

            startActivity(intent)
        }*/

    }

    fun gotologin(view: View) {

        val intent = Intent(this, RegisterActivity::class.java).apply {

        }

        startActivity(intent)

    }

    fun gotoregister(view: View) {
        /*val intent = Intent(this, RegisterActivity::class.java).apply {

        }
        startActivity(intent)*/

        var email = emailEditText.text.toString()
        var password = passwordEditText.text.toString()
        var passwordAgain = passwordAgainEditText.text.toString()
        var nameandsurname = nameAndSurname.text.toString()
        val yourArray: List<String> = nameandsurname.split(" ")



        if (password.equals(passwordAgain)) {

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information

                        val user = auth.currentUser

                        saveFireStore(yourArray[0], yourArray[1], email)
                        Toast.makeText(
                            baseContext, "Succesfull!",
                            Toast.LENGTH_SHORT
                        ).show()
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

        } else {

        }


    }

    fun saveFireStore(firstname: String, lastname: String, email: String) {
        /* val db = FirebaseFirestore.getInstance()
         val user: MutableMap<String, Any> = HashMap()
         user["firstName"] = firstname
         user["lastName"] = lastname*/

        val db = FirebaseFirestore.getInstance()

        data class CreditCard(
            val nameAndSurname: String? = null,
            val creditCardNumber: Long? = null,
            val creditCardstt: Long? = null,
            val cvv: Long? = null,
        )

        data class Users(
            val name: String? = null,
            val surname: String? = null,
            val email: String? = null,
            val country: String? = null,
            val numberOfFlies: Long? = null,
            val bonus: Long? = null,
            val flights: List<String>? = null,
            val creditCardInfo: CreditCard? = null
        )

        val listOfFlies: List<String> = listOf("Antalya", "Corum", "Zurih")

        val users = Users(firstname, lastname, email, null, 3, 20, listOfFlies, null)
        db.collection("users").document(email).set(users).addOnSuccessListener {
            Toast.makeText(this@LoginActivity, "record added successfully ", Toast.LENGTH_SHORT)
                .show()
        }.addOnFailureListener {
            Toast.makeText(this@LoginActivity, "record Failed to add ", Toast.LENGTH_SHORT)
                .show()
        }

        /*db.collection("users")
            .add(user)
            .addOnSuccessListener {
                Toast.makeText(this@LoginActivity, "record added successfully ", Toast.LENGTH_SHORT)
                    .show()
            }
            .addOnFailureListener {
                Toast.makeText(this@LoginActivity, "record Failed to add ", Toast.LENGTH_SHORT)
                    .show()
            }*/

    }


}