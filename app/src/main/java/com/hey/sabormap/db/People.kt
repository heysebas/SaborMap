package com.hey.sabormap.db

import com.hey.sabormap.modelo.Moderator
import com.hey.sabormap.modelo.Person

object People {
    fun login(correo:String, password:String): Person?{
        var respuesta:Person?

        respuesta = Users.listar().firstOrNull{ u -> u.password == password && u.email == correo }

        if(respuesta == null){
            respuesta = Moderators.listar().firstOrNull{ u -> u.password == password && u.email == correo }

//            if(respuesta == null) {
//                respuesta = Administradores.listar().firstOrNull{ u -> u.password == password && u.correo == correo }
//            }
        }

        return respuesta
    }
}