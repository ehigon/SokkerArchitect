package com.estivy.sokkerarchitect.ui.util

import com.estivy.sokkerarchitect.core.domain.PlayerStatus
import com.estivy.sokkerarchitect.core.domain.TrainingType

private const val SECTION_BOUNDARY = 90.0
private const val SPECIFIC_TRAINING_BONUS = 50.0
private const val MAXIMUM_EFFICIENCY = 100.0


fun calculateEfficiency(playerStatus: PlayerStatus): Double {
    if(playerStatus.injured == true){
        return 0.0
    }
    val general = isGeneralTraining(playerStatus)
    val officialMinutes = getofficialMinutesEquivalent(playerStatus)
    var section1 = { t:Double -> t * 1.55 / 3}
    var section2 = { t:Double -> t * 0.35 / 9}
    if(general){
        section1 = { t:Double -> t * 3.1 / 3}
        section2 = { t:Double -> t * 0.31 / 4}
    }

    var efficiency = if(general) 0.0 else SPECIFIC_TRAINING_BONUS
    if(officialMinutes > SECTION_BOUNDARY){
        efficiency += section1(SECTION_BOUNDARY)
        efficiency += section2(officialMinutes- SECTION_BOUNDARY)
    }else{
        efficiency += section1(officialMinutes)
    }

    if(efficiency> MAXIMUM_EFFICIENCY){
        return MAXIMUM_EFFICIENCY
    }
    return efficiency
}

fun getofficialMinutesEquivalent(playerstatus: PlayerStatus): Double {
    val officialMinutes = getValue(playerstatus.officialMinutes)
    val unOfficialMinutes = getValue(playerstatus.unofficialMinutes)
    return officialMinutes.toDouble() + (unOfficialMinutes.toDouble() * 420/558)
}

fun getValue(value: Int?) : Int{
    return value ?: 0
}

fun isGeneralTraining(playerStatus: PlayerStatus): Boolean {
 return (playerStatus.trainingType == TrainingType.GENERAL)
}