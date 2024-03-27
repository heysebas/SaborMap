package com.hey.sabormap.modelo

class User(id: Int, nombre: String, lastName: String, var nickname:String, correo: String, password: String): Person(id, nombre,lastName, correo, password){

    override fun toString(): String {
        return "Usuario(nickname='$nickname') ${super.toString()}"
    }
}