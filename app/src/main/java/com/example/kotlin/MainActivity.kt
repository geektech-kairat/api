package com.example.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.ui.main.MainFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().replace(R.id.container_form, MainFragment())
            .commit()
        setContentView(R.layout.activity_main)
    }
}