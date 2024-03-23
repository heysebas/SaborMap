package com.hey.sabormap.modelo

import java.time.LocalDateTime
import java.util.Date

class Place(
    var id: Int,
    var name: String,
    var description: String,
    var idCreator: Int,
    var state: StatePlace,
    var idCategory:Int,
    var address:String,
    var latitude:Float, var length:Float,
    var idCity:Int
) {

    var phone:List<String> = ArrayList()
    var im:ArrayList<String> = ArrayList()
    var date: Date = Date()
    var schedules:ArrayList<Schedule> = ArrayList()
    override fun toString(): String {
        return "Place(id=$id, name='$name', description='$description', idCreator=$idCreator, state=$state, idCategory=$idCategory, address='$address', latitude=$latitude, length=$length, idCity=$idCity, phone=$phone, im=$im, date=$date, schedules=$schedules)"
    }


}