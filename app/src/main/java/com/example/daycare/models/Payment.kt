package com.example.daycare.models

class Payment {
    var name:String = ""
    var amount:String = ""
    var method:String = ""
    var phone:String = ""
    var id:String = ""
    var userId:String = ""

    constructor(name: String,amount: String,phone: String,method: String,id: String, userId: String) {
        this.name = name
        this.amount= amount
        this.method= method
        this.phone= phone
        this.id = id
        this.userId = userId
    }

    constructor()
}