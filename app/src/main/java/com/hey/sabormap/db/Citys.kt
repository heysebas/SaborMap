package com.hey.sabormap.db

import com.hey.sabormap.modelo.City

object Citys {

    private var citys : ArrayList<City> = ArrayList()

    init {
        Citys.citys.add(City(1,"Armenia"))
    }
}