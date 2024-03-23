package com.hey.sabormap.db

import com.hey.sabormap.R
import com.hey.sabormap.modelo.Category


object Categorys {

    private var categorys:ArrayList<Category> = ArrayList()

    init{
        categorys.add(Category(1, "Árabe", R.drawable.arabe));
        categorys.add(Category(2, "Africana", R.drawable.africana));
        categorys.add(Category(3, "Asiática", R.drawable.asiatica));
        categorys.add(Category(4, "Casera", R.drawable.casera));
        categorys.add(Category(5, "Caribeña", R.drawable.caribena));
        categorys.add(Category(6, "Francesa", 1));
        categorys.add(Category(7, "Fusión", 1));
        categorys.add(Category(8, "Gourmet", 1));
        categorys.add(Category(9, "India", 1));
        categorys.add(Category(10, "Italiana", 1));
        categorys.add(Category(11, "Española", 1));
        categorys.add(Category(12, "Occidental", 1));
        categorys.add(Category(13, "Orgánica", 1));
        categorys.add(Category(14, "Mediterránea", 1));
        categorys.add(Category(15, "Mexicana", 1));
        categorys.add(Category(16, "Vegetariana", 1));
        categorys.add(Category(17, "Vegana", 1));
        categorys.add(Category(18, "Rápida", 1));
        categorys.add(Category(19, "Saludable", 1));
//        categorys.add(Category(20, "Sudamericana"));

    }

    fun listar():ArrayList<Category>{
        return  categorys
    }

    fun ontener(id:Int): Category? {
        return  categorys.firstOrNull { c -> c.id == id }
    }
}