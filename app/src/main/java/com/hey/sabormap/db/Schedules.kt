package com.hey.sabormap.db

import com.hey.sabormap.modelo.DayWeek
import com.hey.sabormap.modelo.Schedule

object Schedules {
    val list: ArrayList<Schedule> = ArrayList()

    fun obtenerTodo():ArrayList<DayWeek> {
        val todoDias:ArrayList<DayWeek> = ArrayList()
        todoDias.addAll(DayWeek.values())
        return  todoDias
    }

    fun obtenerFinSemana():ArrayList<DayWeek> {
        val todoDias:ArrayList<DayWeek> = ArrayList()
        todoDias.add(DayWeek.VIERNES)
        todoDias.add(DayWeek.SABADO)
        return  todoDias
    }

    fun obtenerEntreSemana():ArrayList<DayWeek> {
        val todoDias:ArrayList<DayWeek> = ArrayList()
        todoDias.add(DayWeek.LUNES)
        todoDias.add(DayWeek.MARTES)
        todoDias.add(DayWeek.MIERCOLES)
        todoDias.add(DayWeek.JUEVES)
        todoDias.add(DayWeek.VIERNES)

        return  todoDias
    }

}