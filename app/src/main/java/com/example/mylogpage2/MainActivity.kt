package com.example.mylogpage2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mylogpage2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val arrayGender = resources.getStringArray(R.array.genderr)

        val arrayAdapter = ArrayAdapter(this, R.layout.dropdownitem, arrayGender)

        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)

        autocompleteTV.setAdapter(arrayAdapter)

        with(binding){
            submit.setOnClickListener {
                val email = binding.email.text.toString()
                val fullname = binding.fullname.text.toString()
                val jk = binding.autoCompleteTextView.text.toString()
                val phone = binding.phone.text.toString()
                val username = binding.username.text.toString()
                val password = binding.password.text.toString()

                if (email != "" && fullname != "" && jk != "" && phone != "" && username != "" && password != "") {
                    val intentToSecondActivity = Intent(this@MainActivity, SecondActivity::class.java)
                    intentToSecondActivity.putExtra("Myusername", username)
                    intentToSecondActivity.putExtra("Mypw", password)
                    intentToSecondActivity.putExtra("Myname", fullname)
                    intentToSecondActivity.putExtra("Myemail", email)
                    intentToSecondActivity.putExtra("Myphone", phone)
                    intentToSecondActivity.putExtra("Myjk", jk)
                    startActivity(intentToSecondActivity)
                    Toast.makeText(this@MainActivity, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@MainActivity, "Harap isi semua data untuk mendaftar", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}