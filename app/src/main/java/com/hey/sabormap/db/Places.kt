package com.hey.sabormap.db

import com.hey.sabormap.modelo.Place
import com.hey.sabormap.modelo.Schedule
import com.hey.sabormap.modelo.StatePlace

object Places {
    private val list :ArrayList<Place> = ArrayList()

    init {
        val horario1 = Schedule(1, Schedules.obtenerTodo(), 12, 28)
        val horario2 = Schedule(2, Schedules.obtenerEntreSemana(), 9, 20)
        val horario3 = Schedule(3, Schedules.obtenerFinSemana(), 14, 23)


        val lugar1 = Place(1, "Café ABC", "Excelente café para compartir", 1, StatePlace.ACEPTADO, 2, "Calle 123",73.3434f, -40.4345f, 1)
        lugar1.schedules.add(horario2)
    }



    fun listarPorEstado(estado:StatePlace):ArrayList<Place>{
        return list.filter { l -> l.state == estado }.toCollection(ArrayList())
    }

    fun obtener(id:Int): Place?{
        return list.firstOrNull { l -> l.id == id }
    }

    fun buscarNombre(nombre:String): ArrayList<Place> {
        return list.filter { l -> l.name.lowercase().contains(nombre.lowercase()) && l.state == StatePlace.ACEPTADO }.toCollection(ArrayList())
    }

    fun crear(lugar:Place){
        list.add( lugar )
    }

    fun buscarCiudad(codigoCiudad:Int): ArrayList<Place> {
        return list.filter { l -> l.idCity == codigoCiudad && l.state == StatePlace.ACEPTADO }.toCollection(ArrayList())
    }

    fun buscarCategoria(codigoCategoria:Int): ArrayList<Place> {
        return list.filter { l -> l.idCategory == codigoCategoria && l.state == StatePlace.ACEPTADO }.toCollection(ArrayList())
    }


    fun cambiarEstado(codigo:Int, nuevoEstado:StatePlace){

        val lugar = list.firstOrNull{ l -> l.id == codigo}

        if(lugar!=null){
            lugar.state = nuevoEstado
        }

    }
}