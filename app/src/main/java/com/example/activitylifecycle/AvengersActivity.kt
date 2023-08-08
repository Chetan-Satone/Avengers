package com.example.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.prefs.AbstractPreferences

class AvengersActivity : AppCompatActivity() {

    var titleName: String? = "Avengers"
    lateinit var btLogOut:Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.scrollview_example)

        titleName = sharedPreferences.getString("Title", "The Avengers")

        title= titleName

        btLogOut = findViewById(R.id.btLogOut)

        btLogOut.setOnClickListener {

            startActivity(Intent(this@AvengersActivity, LoginActivity::class.java))
            sharedPreferences.edit().clear().apply()
            finish()
        }

    }
}
