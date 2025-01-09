package com.estivy.sokkerarchitect.ui.util

import com.estivy.sokkerarchitect.core.domain.PlayerStatus
import com.estivy.sokkerarchitect.core.domain.TrainingType
import com.estivy.sokkerarchitect.ui.screens.model.Skill
import junit.framework.TestCase.assertTrue
import org.junit.Test
import kotlin.math.abs

private const val DELTA = 0.1

class EfficiencyCalculatorTest {

    @Test
    fun calculateEfficiencySpecificTest(){
        calculateEfficiencyTest(90, 45, TrainingType.TECHNIQUE, Skill.TECHNIQUE, 97.81)
        calculateEfficiencyTest(0, 180, TrainingType.PACE, Skill.PACE, 98.26)
        calculateEfficiencyTest(0, 0, TrainingType.KEEPER, Skill.KEEPER, 50.0)
        calculateEfficiencyTest(45, 0, TrainingType.PLAYMAKING, Skill.PLAYMAKING, 73.25)
        calculateEfficiencyTest(180, 0, TrainingType.PASSING, Skill.PASSING, 100.0)
        calculateEfficiencyTest(45, 45, TrainingType.DEFENDING, Skill.DEFENDING, 90.75)
    }

    @Test
    fun calculateEfficiencyGeneralTest(){
        calculateEfficiencyTest(90, 45, TrainingType.GENERAL, Skill.PACE, 95.63)
        calculateEfficiencyTest(0, 180, TrainingType.GENERAL, Skill.KEEPER, 96.53)
        calculateEfficiencyTest(0, 0, TrainingType.GENERAL, Skill.PLAYMAKING, 0.0)
        calculateEfficiencyTest(45, 0, TrainingType.GENERAL, Skill.PASSING, 46.5)
        calculateEfficiencyTest(180, 0, TrainingType.GENERAL, Skill.TECHNIQUE, 100.0)
        calculateEfficiencyTest(45, 45, TrainingType.TECHNIQUE, Skill.DEFENDING, 81.49)
    }

    fun calculateEfficiencyTest(officialMinutes: Int,
                                unofficialMinutes: Int,
                                trainingType: TrainingType,
                                skill: Skill,
                                expectedEfficiency: Double){
        val playerStatus = PlayerStatus.builder()
            .officialMinutes(officialMinutes)
            .unofficialMinutes(unofficialMinutes)
            .trainingType(trainingType)
            .build()

        val efficiency = calculateEfficiency(playerStatus, skill)

        assertTrue("expected ${expectedEfficiency} found ${efficiency} with official minutes ${officialMinutes} and unofficial minutes ${unofficialMinutes}",
            abs(efficiency - expectedEfficiency) < DELTA)
    }

}