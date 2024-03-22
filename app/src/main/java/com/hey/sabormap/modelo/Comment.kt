package com.hey.sabormap.modelo

import java.time.LocalDateTime

class Comment(
    var id: Int,
    var text: String,
    var idUser: Int,
    var idPlace: Int,
    var qualification: Int,
) {
}