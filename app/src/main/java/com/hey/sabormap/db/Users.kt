package com.hey.sabormap.db

import com.hey.sabormap.modelo.User

object Users {
    private val users: ArrayList<User> = ArrayList()

    init {
        users.add(User(1, "sebas", "sebaz@email", "heysebas", "12345678"))
    }

    fun listar(): ArrayList<User> {
        return users
    }

    fun agregar(user: User) {
        users.add(user)
    }

    fun login(email: String, password: String): User {
        val respuesta = users.first { u -> u.password == password && u.email == email }
        return respuesta
    }
}