package com.example.daycare.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.daycare.models.Emergency
import com.example.daycare.navigation.ROUT_LOGIN
import com.example.daycare.navigation.VIEW_EMERGENCY
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EmergencyViewModel(var navController: NavHostController, var context: Context) {
    var authViewModel: AuthViewModel
    var progress: ProgressDialog

    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()) {
            navController.navigate(ROUT_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadEmergency(name: String, phone: String) {
        val emergencyId = System.currentTimeMillis().toString()

        val currentUser = FirebaseAuth.getInstance().currentUser
        val userId = currentUser?.uid

        val emergency = Emergency(name, phone, emergencyId, userId ?: "")
        val databaseRef = FirebaseDatabase.getInstance().getReference()
            .child("Emergencys/$emergencyId")
        databaseRef.setValue(emergency).addOnCompleteListener {
            if (it.isSuccessful) {
                navController.navigate(VIEW_EMERGENCY)
                Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun deleteEmergency(emergencyId: String) {
        val ref = FirebaseDatabase.getInstance().getReference()
            .child("Emergencys/$emergencyId")
        ref.removeValue()
        Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show()
    }

    fun updateEmergency(emergencyId: String) {
        val ref = FirebaseDatabase.getInstance().getReference()
            .child("Emergencys/$emergencyId")
        ref.removeValue()
        navController.navigate(VIEW_EMERGENCY)
    }

    fun ViewEmergency(
        emergency: MutableState<Emergency>,
        emergencys: SnapshotStateList<Emergency>
    ): SnapshotStateList<Emergency> {
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Emergencys")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                emergencys.clear()
                for (snap in snapshot.children) {
                    var retrievedemergency = snap.getValue(Emergency::class.java)
                    emergency.value = retrievedemergency!!
                    emergencys.add(retrievedemergency)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return emergencys
    }
}
