package com.estivy.sokkerarchitect.storage.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.estivy.sokkerarchitect.core.domain.JuniorFormation;

@Entity(tableName = "junior_statuses",
        foreignKeys = {
                @ForeignKey(entity = PlayerEntity.class,
                        parentColumns = "id",
                        childColumns = "playerId")
        })
public class JuniorStatusEntity {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(index = true)
    private Long playerId;
    private Integer skill;
    private JuniorFormation formation;
    private Integer remainingWeeks;
    private Long week;
    private Integer age;
    private Integer trainerSkill;

    public JuniorStatusEntity() {
    }

    @Ignore
    public JuniorStatusEntity(Long id, Long playerId, Integer skill, JuniorFormation formation,
                              Integer remainingWeeks, Long week, Integer age, Integer trainerSkill) {
        this.id = id;
        this.playerId = playerId;
        this.skill = skill;
        this.formation = formation;
        this.remainingWeeks = remainingWeeks;
        this.week = week;
        this.age = age;
        this.trainerSkill = trainerSkill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public JuniorFormation getFormation() {
        return formation;
    }

    public void setFormation(JuniorFormation formation) {
        this.formation = formation;
    }

    public Integer getRemainingWeeks() {
        return remainingWeeks;
    }

    public void setRemainingWeeks(Integer remainingWeeks) {
        this.remainingWeeks = remainingWeeks;
    }

    public Long getWeek() {
        return week;
    }

    public void setWeek(Long week) {
        this.week = week;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTrainerSkill() {
        return trainerSkill;
    }

    public void setTrainerSkill(Integer trainerSkill) {
        this.trainerSkill = trainerSkill;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long playerId;
        private Integer skill;
        private JuniorFormation formation;
        private Integer remainingWeeks;
        private Long week;
        private Integer age;
        private Integer trainerSkill;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder playerId(Long playerId) { this.playerId = playerId; return this; }
        public Builder skill(Integer skill) { this.skill = skill; return this; }
        public Builder formation(JuniorFormation formation) { this.formation = formation; return this; }
        public Builder remainingWeeks(Integer remainingWeeks) { this.remainingWeeks = remainingWeeks; return this; }
        public Builder week(Long week) { this.week = week; return this; }
        public Builder age(Integer age) { this.age = age; return this; }
        public Builder trainerSkill(Integer trainerSkill) { this.trainerSkill = trainerSkill; return this; }

        public JuniorStatusEntity build() {
            return new JuniorStatusEntity(id, playerId, skill, formation, remainingWeeks, week, age, trainerSkill);
        }
    }
}
