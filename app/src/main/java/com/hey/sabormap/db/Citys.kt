package com.hey.sabormap.db

import com.hey.sabormap.modelo.City

object Citys {

    private var list : ArrayList<City> = ArrayList()

    init {
        list.add(City(1, "Armenia"))
        list.add(City(2, "Calarcá"))
        list.add(City(3, "Circasia"))
        list.add(City(4, "Filandia"))
        list.add(City(5, "Génova"))
        list.add(City(6, "La Tebaida"))
        list.add(City(7, "Montenegro"))
        list.add(City(8, "Pijao"))
        list.add(City(9, "Quimbaya"))
        list.add(City(10, "Salento"))
    }

    fun listar():ArrayList<City>{
        return list
    }

    fun obtener(id:Int): City?{
        return  list.firstOrNull{ c -> c.id == id}
    }
}