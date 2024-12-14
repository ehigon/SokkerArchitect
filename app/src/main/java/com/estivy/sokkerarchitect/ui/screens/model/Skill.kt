package com.estivy.sokkerarchitect.ui.screens.model

import com.estivy.sokkerarchitect.core.domain.PlayerStatus
import com.estivy.sokkerarchitect.core.domain.TrainingType

enum class Skill(val skill: (PlayerStatus) -> Int, val trained: (PlayerStatus) -> Boolean) {
    DISCIPLINE(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillDiscipline },
        trained = { false }
    ),
    FORM(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillForm },
        trained = { false }
    ),
    STAMINA(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillStamina },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.STAMINA }
    ),
    PACE(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillPace },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.PACE }
    ),
    TECHNIQUE(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillTechnique },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.TECHNIQUE }
    ),
    PASSING(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillPassing },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.PASSING }

    ),
    KEEPER(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillKeeper },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.KEEPER }
    ),
    DEFENDING(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillDefending },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.DEFENDING }
    ),
    PLAYMAKING(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillPlaymaking },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.PLAYMAKING }
    ),
    SCORING(
        skill = { playerStatus: PlayerStatus -> playerStatus.skillScoring },
        trained = { playerStatus: PlayerStatus -> playerStatus.trainingType == TrainingType.SCORING }
    );

}