package com.estivy.sokkerarchitect.external.api.client.mapper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.estivy.sokkerarchitect.external.api.client.dto.PlayerDto;
import com.estivy.sokkerarchitect.external.api.client.dto.VarsDto;

import org.junit.Test;

public class PlayerMapperTest {

    PlayerMapper playerMapper = PlayerMapper.INSTANCE;

    @Test
    public void given_6DayInjuredAndDay5_when_isInjuredInTrainingDay_then_returnsTrue() {
        PlayerDto player = new PlayerDto();
        player.setInjuryDays(6);
        VarsDto vars = new VarsDto();
        vars.setDay(5);

        assertTrue(playerMapper.isInjuredInTrainingDay(player, vars));
    }

    @Test
    public void given_0DayInjuredAndDay4_when_isInjuredInTrainingDay_then_returnsFalse() {
        PlayerDto player = new PlayerDto();
        player.setInjuryDays(0);
        VarsDto vars = new VarsDto();
        vars.setDay(4);

        assertFalse(playerMapper.isInjuredInTrainingDay(player, vars));
    }

    @Test
    public void given_1DayInjuredAndDay4_when_isInjuredInTrainingDay_then_returnsTrue() {
        PlayerDto player = new PlayerDto();
        player.setInjuryDays(1);
        VarsDto vars = new VarsDto();
        vars.setDay(4);

        assertTrue(playerMapper.isInjuredInTrainingDay(player, vars));
    }

    @Test
    public void given_4DayInjuredAndDay5_when_isInjuredInTrainingDay_then_returnsFalse() {
        PlayerDto player = new PlayerDto();
        player.setInjuryDays(4);
        VarsDto vars = new VarsDto();
        vars.setDay(5);

        assertFalse(playerMapper.isInjuredInTrainingDay(player, vars));
    }

    @Test
    public void given_5DayInjuredAndDay7_when_isInjuredInTrainingDay_then_returnsTrue() {
        PlayerDto player = new PlayerDto();
        player.setInjuryDays(5);
        VarsDto vars = new VarsDto();
        vars.setDay(7);

        assertTrue(playerMapper.isInjuredInTrainingDay(player, vars));
    }

    @Test
    public void given_4DayInjuredAndDay7_when_isInjuredInTrainingDay_then_returnsFalse() {
        PlayerDto player = new PlayerDto();
        player.setInjuryDays(3);
        VarsDto vars = new VarsDto();
        vars.setDay(7);

        assertFalse(playerMapper.isInjuredInTrainingDay(player, vars));
    }

}