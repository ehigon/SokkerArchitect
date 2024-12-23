package com.estivy.sokkerarchitect.ui.screens.model

import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.domain.PlayerStatus
import com.estivy.sokkerarchitect.core.domain.TrainingType

enum class Skill(
    val skill: (PlayerStatus) -> Int, val trained: (PlayerStatus) -> Boolean, val resource: Int
) {
    DISCIPLINE(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillDiscipline },
        trained = { false },
        resource = R.string.tactical_discipline
    ),
    FORM(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillForm },
        trained = { false },
        resource = R.string.form
    ),
    STAMINA(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillStamina },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.STAMINA },
        resource = R.string.stamina
    ),
    PACE(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillPace },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.PACE },
        resource = R.string.pace
    ),
    TECHNIQUE(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillTechnique },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.TECHNIQUE },
        resource = R.string.technique
    ),
    PASSING(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillPassing },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.PASSING },
        resource = R.string.passing
    ),
    KEEPER(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillKeeper },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.KEEPER },
        resource = R.string.keeper
    ),
    DEFENDING(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillDefending },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.DEFENDING },
        resource = R.string.defender
    ),
    PLAYMAKING(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillPlaymaking },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.PLAYMAKING },
        resource = R.string.playmaker
    ),
    SCORING(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillScoring },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.SCORING },
        resource = R.string.striker
    );

}