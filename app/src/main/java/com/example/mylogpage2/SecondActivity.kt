package com.example.mylogpage2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mylogpage2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val username = intent.getStringExtra("Myusername")
        val password = intent.getStringExtra("Mypw")
        val fullname = intent.getStringExtra("Myname")
        val email = intent.getStringExtra("Myemail")
        val phone = intent.getStringExtra("Myphone")
        val jk = intent.getStringExtra("Myjk")

        with(binding){
            submit.setOnClickListener {
                val newuser = binding.username.text.toString()
                val newpw = binding.password.text.toString()
                if (binding.username.text.toString() != "" && binding.password.text.toString() != ""){
                    if (username == newuser && password == newpw) {
                        val intentThird = Intent(this@SecondActivity, ThirdActivity::class.java)
                        intentThird.putExtra("Myname", fullname)
                        intentThird.putExtra("Myemail", email)
                        intentThird.putExtra("Myphone", phone)
                        intentThird.putExtra("Myjk", jk)
                        startActivity(intentThird)
                    }else{
                        Toast.makeText(this@SecondActivity, "Username atau password salah", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this@SecondActivity, "Harap isi semua data untuk masuk", Toast.LENGTH_SHORT).show()
                }

            }
        }

    }
}