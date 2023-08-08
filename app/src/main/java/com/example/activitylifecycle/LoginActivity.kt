package com.example.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var etMobileNumber: EditText
    lateinit var etPass: EditText
    lateinit var btLoginHere: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val validMobileNumber = "012345678"
    val validPassword = arrayOf( "tony","steve", "bruce", "thanos" )

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences= getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        setContentView(R.layout.activity_login)

        if(isLoggedIn){
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPass = findViewById(R.id.etPass)
        btLoginHere= findViewById(R.id.btLoginHere)
        txtForgotPassword= findViewById(R.id.txtForgotPassword)
        txtRegister= findViewById(R.id.txtRegister)

        btLoginHere.setOnClickListener {

            val MobileNumber = etMobileNumber.text.toString()

            val Password = etPass.text.toString()

            val nameOfAvenger: String

            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)

            if( (MobileNumber== validMobileNumber) ) {

                when (Password) {
                    validPassword[0] -> {

                        nameOfAvenger = "Iron Man"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)

                    }
                    validPassword[1] -> {

                        nameOfAvenger = "Caption America"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)

                    }
                    validPassword[2] -> {

                        nameOfAvenger= "Hulk"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)

                    }
                    validPassword[3] -> {

                        nameOfAvenger = "The Avengers"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)
                    }
                }

            }else{
                Toast.makeText(this@LoginActivity,"This is invalid",Toast.LENGTH_LONG).show()
            }
        }
        txtRegister.setOnClickListener{
            val intent = Intent(this@LoginActivity, Register::class.java)
            startActivity(intent)
        }
        txtForgotPassword.setOnClickListener {
            val intent= Intent(this@LoginActivity, ForgotPasswordActivity::class.java )
            startActivity(intent)
        }

    }
    override fun onPause(){
        super.onPause()
        finish()

    }
    private fun savePreferences (title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}
