package com.example.smartedu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.smartedu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tv:TextView
    private lateinit var binding: ActivityMainBinding
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(androidx.fragment.R.id.fragment_container_view_tag,fragment)
        fragmentTransaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.textView2)

        val username = intent.getParcelableExtra<User>("User")?.username
        val password = intent.getParcelableExtra<User>("User")?.password
        tv.text = "Username: $username dan Password: $password"

        val btnImplicit: Button = findViewById(R.id.btn_implict)
        btnImplicit.setOnClickListener(this)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRed.setOnClickListener { replaceFragment(Fragment_1()) }
        binding.btnBlue.setOnClickListener { replaceFragment(Fragment_2()) }

    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.btn_implict -> {

                val intent = Intent()
                intent.putExtra("history", "Anda sudah login")
                setResult(RESULT_OK,intent)
                finish()
            }
        }
    }
}