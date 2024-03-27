package com.hey.sabormap.modelo

class Moderator(id: Int, nombre: String, lastName: String, correo: String, password: String): Person(id, nombre, lastName, correo, password) {

    override fun toString(): String {
        return "Moderador() ${super.toString()}"
    }

}