package com.estivy.sokkerarchitect.ui.screens.model

import com.estivy.sokkerarchitect.core.domain.PlayerStatus

data class TrainingWeekClickedEvent(val week: Int, val playerStatus: PlayerStatus)