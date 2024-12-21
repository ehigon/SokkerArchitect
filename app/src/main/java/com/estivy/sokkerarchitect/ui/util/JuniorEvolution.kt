package com.estivy.sokkerarchitect.ui.util

import com.estivy.sokkerarchitect.core.domain.JuniorStatus
import com.estivy.sokkerarchitect.core.domain.Player

class JuniorEvolution {

    var currentWeek: JuniorStatus

    private var lastWeek: JuniorStatus

    constructor(player: Player){
        val optCurrentWeek = player.juniorStatuses.maxBy { ps -> ps.week }
        currentWeek = optCurrentWeek?: JuniorStatus()
        val optLastWeek: JuniorStatus? = player.juniorStatuses
            .filter { ps -> ps.week != currentWeek.week }.maxByOrNull { ps -> ps.week }
        lastWeek = optLastWeek?:currentWeek
    }

    fun getSkill(): Int {
        return currentWeek.skill - lastWeek.skill
    }

}