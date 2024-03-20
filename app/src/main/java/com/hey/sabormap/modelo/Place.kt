package com.hey.sabormap.modelo

import java.time.LocalDateTime

class Place(
    var id: Int,
    var name: String,
    var description: String,
    var img: List<String>,
    var idCreator: Int,
    var state: Boolean,
    var idCategory:Int,
    var idCity:Int,
    var idState:Int,
    var latitude:Float, var length:Float,
    var date: LocalDateTime
) {
    var phone:List<String> = ArrayList()

}