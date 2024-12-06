package com.estivy.sokkerarchitect.ui.util

import com.estivy.sokkerarchitect.core.domain.Player
import com.estivy.sokkerarchitect.core.domain.PlayerStatus

class Evolution{

    var currentWeek: PlayerStatus

    private var lastWeek: PlayerStatus

    constructor(player: Player){
        val optCurrentWeek = player.playerStatuses.maxBy { ps -> ps.week }
        currentWeek = optCurrentWeek?:PlayerStatus()
        val optLastWeek: PlayerStatus? = player.playerStatuses
            .filter { ps -> ps.week != currentWeek.week }.maxByOrNull { ps -> ps.week }
        lastWeek = optLastWeek?:currentWeek
    }

    fun getSkillForm(): Int{
        if(currentWeek.skillForm == null){
            return 0
        }
        return currentWeek.skillForm - lastWeek.skillForm
    }

    fun getSkillExperience(): Int{
        if(currentWeek.skillExperience == null){
            return 0
        }
        return currentWeek.skillExperience - lastWeek.skillExperience
    }

    fun getSkillTeamwork(): Int{
        if(currentWeek.skillTeamwork == null){
            return 0
        }
        return currentWeek.skillTeamwork - lastWeek.skillTeamwork
    }

    fun getSkillDiscipline(): Int{
        if(currentWeek.skillDiscipline == null){
            return 0
        }
        return currentWeek.skillDiscipline - lastWeek.skillDiscipline
    }

    fun getSkillStamina(): Int{
        if(currentWeek.skillStamina == null){
            return 0
        }
        return currentWeek.skillStamina - lastWeek.skillStamina
    }

    fun getSkillPace(): Int{
        if(currentWeek.skillPace == null){
            return 0
        }
        return currentWeek.skillPace - lastWeek.skillPace
    }

    fun getSkillTechnique(): Int{
        if(currentWeek.skillTechnique == null){
            return 0
        }
        return currentWeek.skillTechnique - lastWeek.skillTechnique
    }

    fun getSkillPassing(): Int{
        if(currentWeek.skillPassing == null){
            return 0
        }
        return currentWeek.skillPassing - lastWeek.skillPassing
    }

    fun getSkillKeeper(): Int{
        if(currentWeek.skillKeeper == null){
            return 0
        }
        return currentWeek.skillKeeper - lastWeek.skillKeeper
    }

    fun getSkillDefending(): Int{
        if(currentWeek.skillDefending == null){
            return 0
        }
        return currentWeek.skillDefending - lastWeek.skillDefending
    }

    fun getSkillPlaymaking(): Int{
        if(currentWeek.skillPlaymaking == null){
            return 0
        }
        return currentWeek.skillPlaymaking - lastWeek.skillPlaymaking
    }

    fun getSkillScoring(): Int{
        if(currentWeek.skillScoring == null){
            return 0
        }
        return currentWeek.skillScoring - lastWeek.skillScoring
    }

    fun getIncreases(): Int {
        var increases = 0
        if(getSkillPace() > 0){
            increases++
        }
        if(getSkillTechnique() > 0){
            increases++
        }
        if(getSkillPassing() > 0){
            increases++
        }
        if(getSkillKeeper() > 0){
            increases++
        }
        if(getSkillDefending() > 0){
            increases++
        }
        if(getSkillPlaymaking() > 0){
            increases++
        }
        if(getSkillScoring() > 0){
            increases++
        }

        return increases
    }

    fun getDecreases(): Int {
        var decreases = 0

        if(getSkillPace() < 0){
            decreases++
        }
        if(getSkillTechnique() < 0){
            decreases++
        }
        if(getSkillPassing() < 0) {
            decreases++
        }
        if(getSkillKeeper() < 0){
            decreases++
        }
        if(getSkillDefending() < 0) {
            decreases++
        }
        if(getSkillPlaymaking() < 0){
            decreases++
        }
        if(getSkillScoring() < 0) {
            decreases++
        }
        return decreases
    }
}