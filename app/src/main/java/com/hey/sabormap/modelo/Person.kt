package com.hey.sabormap.modelo

open class Person(var id:Int,var name:String, var lastName:String,var email:String, var password:String) {

    override fun toString(): String {
        return "Person(id=$id, nombre='$name', lastNAme = '$lastName',correo='$email', password='$password')"
    }

}