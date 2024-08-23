package com.example.daycare.models

class Emergency {
    var name:String = ""
    var phone:String = ""
    var id:String = ""
    var userId:String = ""

    constructor(name: String, phone: String, id: String, userId: String) {
        this.name = name
        this.phone= phone
        this.id = id
        this.userId = userId
    }

    constructor()

}