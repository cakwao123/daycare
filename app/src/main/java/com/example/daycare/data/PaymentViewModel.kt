package com.example.daycare.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.daycare.models.Payment
import com.example.daycare.navigation.ROUT_LOGIN
import com.example.daycare.navigation.ROUT_PAYMENT
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.auth.FirebaseAuth

class PaymentViewModel(var navController: NavController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress: ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(ROUT_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadPayment(name:String, method:String, amount:String, phone: String){
      val paymentId = System.currentTimeMillis().toString()

      val currentUser = FirebaseAuth.getInstance().currentUser
      val userId = currentUser?.uid

      val payment = Payment(name, phone, amount,method,paymentId, userId ?: "")
      val databaseRef = FirebaseDatabase.getInstance().getReference()
        .child("Payments/$paymentId")
      databaseRef.setValue(payment).addOnCompleteListener {
        if (it.isSuccessful) {
          navController.navigate(ROUT_PAYMENT)
          Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
        } else {
          Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
        }
      }

    }

    fun allPayments(
        payment: MutableState<Payment>,
        payments: SnapshotStateList<Payment>):SnapshotStateList<Payment>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Payments")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                payments.clear()
                for (snap in snapshot.children){
                    var retrievedPayment = snap.getValue(Payment::class.java)
                    payment.value = retrievedPayment!!
                    payments.add(retrievedPayment)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return payments
    }

    fun updatePayment(paymentId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Payments/$paymentId")
        ref.removeValue()
        navController.navigate(ROUT_PAYMENT)
    }


    fun deletePayment(PaymentId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Payments/$PaymentId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }

    fun ViewPayment(
      mutableState: MutableState<Payment>,
      payments: androidx.compose.runtime.snapshots.SnapshotStateList<com.example.daycare.models.Payment>
    ) {
    }
}
