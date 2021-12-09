package com.example.appbasica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.appbasica.databinding.ActivityMainBinding
import com.example.appbasica.databinding.ActivityManagerQrBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run { imageView.setImageBitmap() }
        variables()
    }

    private fun variables(){
        println(IDGenerator.getRandomString(15))
        UserProfile("Billy","Billyflin","OWO")
        val ID = UserProfile.getID()
        println(ID)
    }
}

private fun ImageView.setImageBitmap() {
    
}
