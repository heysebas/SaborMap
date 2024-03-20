package com.hey.sabormap.db

import com.hey.sabormap.modelo.Country

object Coutries {

    private var coutries: ArrayList<Country> = ArrayList()

    init{
        Coutries.coutries.add(Country(1, "Colombia"));
    }
}