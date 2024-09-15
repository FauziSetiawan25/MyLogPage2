package com.example.mylogpage2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mylogpage2.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private val binding by lazy { ActivityThirdBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val fullname = intent.getStringExtra("Myname")
        val email = intent.getStringExtra("Myemail")
        val phone = intent.getStringExtra("Myphone")
        val jk = intent.getStringExtra("Myjk")
        with(binding){
            binding.name.text = binding.name.text.toString().plus(fullname)
            binding.email.text = binding.email.text.toString().plus(email)
            binding.phone.text = binding.phone.text.toString().plus(phone)
            binding.gender.text = binding.gender.text.toString().plus(jk)
        }

    }
}