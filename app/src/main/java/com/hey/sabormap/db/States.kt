package com.hey.sabormap.db

import com.hey.sabormap.modelo.State

object States {
    private var states : ArrayList<State> = ArrayList()

    init {
        States.states.add(State(1,"Quindio"))
    }
}