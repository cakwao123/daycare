package com.example.daycare.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.daycare.models.Account
import com.example.daycare.navigation.ADD_ACCOUNT
import com.example.daycare.navigation.ROUT_LOGIN
import com.example.daycare.navigation.VIEW_ACCOUNT
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class AccountViewModel(var navController: NavController, var context: Context) {
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

    fun addAccount(name:String, email:String, age:String, filePath: Uri){
        val accountId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Accounts/$accountId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var account = Account(name,age,email,imageUrl,accountId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Accounts/$accountId")
                    databaseRef.setValue(account).addOnCompleteListener {
                        if (it.isSuccessful){
                            navController.navigate(VIEW_ACCOUNT)
                            Toast.makeText(this.context, "Successfully created an account", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun ViewAccount(account: MutableState<Account>, accounts: SnapshotStateList<Account>):SnapshotStateList<Account>{
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Accounts")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                accounts.clear()
                for (snap in snapshot.children){
                    var retrievedAccount = snap.getValue(Account::class.java)
                    account.value = retrievedAccount!!
                    accounts.add(retrievedAccount)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return accounts
    }

    fun updateAccount(accountId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Account/$accountId")
        ref.removeValue()
        navController.navigate(ADD_ACCOUNT)
    }


    fun deleteAccount(accountId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Accounts/$accountId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}

