package com.hey.sabormap.db

import com.hey.sabormap.modelo.Moderator

object Moderators {
    private val lista:ArrayList<Moderator> = ArrayList()

    init {
        lista.add( Moderator(1, "Moderador1", "Moderador1", "mode1@email.com", "1234"))
        lista.add( Moderator(1, "Moderador2", "Moderador2", "mode2@email.com", "1234"))
    }

    fun listar():ArrayList<Moderator>{
        return lista
    }

    fun obtener(id:Int): Moderator?{
        return lista.firstOrNull { a -> a.id == id }
    }
}