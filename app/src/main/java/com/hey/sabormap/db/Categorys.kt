package com.hey.sabormap.db

import com.hey.sabormap.modelo.Category


object Categorys {

    private var categorys:ArrayList<Category> = ArrayList()

    init{
        categorys.add(Category(1, "Árabe"));
        categorys.add(Category(2, "Africana"));
        categorys.add(Category(3, "Asiática"));
        categorys.add(Category(4, "Casera"));
        categorys.add(Category(5, "Caribeña"));
        categorys.add(Category(6, "Francesa"));
        categorys.add(Category(7, "Fusión"));
        categorys.add(Category(8, "Gourmet"));
        categorys.add(Category(9, "India"));
        categorys.add(Category(10, "Italiana"));
        categorys.add(Category(11, "Española"));
        categorys.add(Category(12, "Occidental"));
        categorys.add(Category(13, "Orgánica"));
        categorys.add(Category(14, "Mediterránea"));
        categorys.add(Category(15, "Mexicana"));
        categorys.add(Category(16, "Vegetariana"));
        categorys.add(Category(17, "Vegana"));
        categorys.add(Category(18, "Rápida"));
        categorys.add(Category(19, "Saludable"));
        categorys.add(Category(20, "Sudamericana"));

    }

    fun listar():ArrayList<Category>{
        return  categorys
    }

    fun ontener(id:Int): Category? {
        return  categorys.firstOrNull { c -> c.id == id }
    }
}