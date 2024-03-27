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

        val lugar2 = Place(2, "Bar City Pub", "Bar en la ciudad de Armenia", 2, StatePlace.ACEPTADO, 5, "Calle 12 # 23-1",73.3434f, -40.4345f, 1)
        lugar2.schedules.add(horario1)

        val lugar3 = Place(3, "Restaurante Mi Cuate", "Comida Mexicana para todos", 3, StatePlace.ACEPTADO, 3, "Calle 452",73.3434f, -40.4345f, 5)
        lugar3.schedules.add(horario1)

        val lugar4 = Place(4, "BBC Norte Pub", "Cervezas BBC muy buenas", 1, StatePlace.ACEPTADO, 1, "Calle 53",73.3434f, -40.4345f, 3)
        lugar4.schedules.add(horario3)

        val lugar5 = Place(5, "Hotel barato", "Hotel para ahorrar mucho dinero", 1, StatePlace.ACEPTADO, 1, "Calle 23 # 34-1",73.3434f, -40.4345f, 1)
        lugar5.schedules.add( horario1 )

        val lugar6 = Place(6, "Hostal Hippie", "Alojamiento para todos y todas", 2, StatePlace.SIN_REVISAR, 1, "Carrera 123",73.3434f, -40.4345f, 2)
        lugar6.schedules.add( horario2 )

        val lugar7 = Place(7, "Café ABC", "Excelente café para compartir", 1, StatePlace.ACEPTADO, 2, "Calle 123",73.3434f, -40.4345f, 1)
        lugar1.schedules.add(horario2)

        val lugar8 = Place(8, "Bar City Pub", "Bar en la ciudad de Armenia", 2, StatePlace.ACEPTADO, 5, "Calle 12 # 23-1",73.3434f, -40.4345f, 1)
        lugar2.schedules.add(horario1)

        val lugar9 = Place(9, "Restaurante Mi Cuate", "Comida Mexicana para todos", 3, StatePlace.ACEPTADO, 3, "Calle 452",73.3434f, -40.4345f, 5)
        lugar3.schedules.add(horario1)

        val lugar10 = Place(10, "BBC Norte Pub", "Cervezas BBC muy buenas", 1, StatePlace.ACEPTADO, 1, "Calle 53",73.3434f, -40.4345f, 3)
        lugar4.schedules.add(horario3)

        val lugar11 = Place(11, "Hotel barato", "Hotel para ahorrar mucho dinero", 1, StatePlace.ACEPTADO, 1, "Calle 23 # 34-1",73.3434f, -40.4345f, 1)
        lugar5.schedules.add( horario1 )

        val lugar12 = Place(12, "Hostal Hippie", "Alojamiento para todos y todas", 2, StatePlace.SIN_REVISAR, 1, "Carrera 123",73.3434f, -40.4345f, 2)
        lugar6.schedules.add( horario2 )
        val lugar13 = Place(13, "Café ABC", "Excelente café para compartir", 1, StatePlace.ACEPTADO, 2, "Calle 123",73.3434f, -40.4345f, 1)
        lugar1.schedules.add(horario2)

        val lugar14 = Place(14, "Bar City Pub", "Bar en la ciudad de Armenia", 2, StatePlace.ACEPTADO, 5, "Calle 12 # 23-1",73.3434f, -40.4345f, 1)
        lugar2.schedules.add(horario1)

        val lugar15 = Place(15, "Restaurante Mi Cuate", "Comida Mexicana para todos", 3, StatePlace.ACEPTADO, 3, "Calle 452",73.3434f, -40.4345f, 5)
        lugar3.schedules.add(horario1)

        val lugar16 = Place(16, "BBC Norte Pub", "Cervezas BBC muy buenas", 1, StatePlace.ACEPTADO, 1, "Calle 53",73.3434f, -40.4345f, 3)
        lugar4.schedules.add(horario3)

        val lugar17 = Place(17, "Hotel barato", "Hotel para ahorrar mucho dinero", 1, StatePlace.ACEPTADO, 1, "Calle 23 # 34-1",73.3434f, -40.4345f, 1)
        lugar5.schedules.add( horario1 )

        val lugar18 = Place(18, "Hostal Hippie", "Alojamiento para todos y todas", 2, StatePlace.SIN_REVISAR, 1, "Carrera 123",73.3434f, -40.4345f, 2)
        lugar6.schedules.add( horario2 )

        list.add( lugar1 )
        list.add( lugar2 )
        list.add( lugar3 )
        list.add( lugar4 )
        list.add( lugar5 )
        list.add( lugar6 )
        list.add( lugar7 )
        list.add( lugar8 )
        list.add( lugar9 )
        list.add( lugar10 )
        list.add( lugar11 )
        list.add( lugar12 )
        list.add( lugar13 )
        list.add( lugar14 )
        list.add( lugar15 )
        list.add( lugar16 )
        list.add( lugar17 )
        list.add( lugar18 )
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