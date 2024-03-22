package com.hey.sabormap.db

import com.hey.sabormap.modelo.Comment

object Comments {
    private val list: ArrayList<Comment> = ArrayList()

    init{
        list.add(Comment(1,"Es muy bueno",1,1,1))

    }

    fun listar(idPlace:Int):ArrayList<Comment>{
        return list.filter { c -> c.idPlace == idPlace }.toCollection(ArrayList())
    }

    fun crear(comment: Comment){
        list.add(comment)
    }
}