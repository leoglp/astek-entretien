package com.example.astekentretien

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.astekentretien.utils.AuthenticationUtil.Companion.signIn
import com.example.astekentretien.utils.ShowUtil.Companion.hideKeyboard
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectButton.setOnClickListener{
            hideKeyboard(this,it)
            signIn(this,it,mailEditText.text.toString(), passwordEditText.text.toString())
        }

        subscribeText.setOnClickListener{
            val intent = Intent(this, ProfilCreation::class.java)
            startActivity(intent)
        }
    }
}
