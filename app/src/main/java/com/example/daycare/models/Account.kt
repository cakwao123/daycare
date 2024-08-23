package com.example.daycare.models

class Account {

    var name:String = ""
    var email:String = ""
    var age:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, email: String, age: String,imageUrl: String, id: String) {
        this.name = name
        this.email = email
        this.age= age
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}