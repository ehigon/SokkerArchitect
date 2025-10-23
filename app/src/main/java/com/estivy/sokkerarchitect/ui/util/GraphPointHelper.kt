package com.estivy.sokkerarchitect.ui.util

import com.estivy.sokkerarchitect.core.domain.Player
import com.estivy.sokkerarchitect.ui.screens.model.GraphPoint
import com.estivy.sokkerarchitect.ui.theme.greenGraph

fun getGraphPoints(player: Player): List<GraphPoint> {
    return player.juniorStatuses.sortedBy { it.week }
        .map {
            GraphPoint(
                value = it.skill,
                bar = (if (it.trainerSkill == null) 18 else it.trainerSkill) / 18.0F,
                color = greenGraph,
                week = if (it.week == null) 0 else it.week.toInt()
            )
        }
}