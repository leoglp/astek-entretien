package com.example.astekentretien.utils

import android.app.Activity
import android.content.Intent
import android.view.View
import com.example.astekentretien.MainActivity
import com.example.astekentretien.R
import com.example.astekentretien.TestActivity
import com.example.astekentretien.utils.ShowUtil.Companion.showMessage
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class AuthenticationUtil {

    companion object {

        private val fbAuth = FirebaseAuth.getInstance()

        fun signIn(activity: Activity, view: View, email: String, password: String){
            showMessage(view,activity.getString(R.string.authentication))

            fbAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(activity) { task ->
                if(task.isSuccessful) {
                    val intent = Intent(activity, TestActivity::class.java)
                    intent.putExtra("id", fbAuth.currentUser?.email)
                    activity.startActivity(intent)
                } else {
                    showMessage(view,"Error: ${task.exception?.message}")
                }
            }

        }





        fun createUser(activity: Activity, view: View, email: String, password: String){

            showMessage(view,activity.getString(R.string.creation))

            fbAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task: Task<AuthResult> ->
                if (task.isSuccessful) {
                    val intent = Intent(activity, MainActivity::class.java)
                    activity.startActivity(intent)
                } else {
                    showMessage(view,"Error: ${task.exception?.message}")
                }
            }
        }


    }
}