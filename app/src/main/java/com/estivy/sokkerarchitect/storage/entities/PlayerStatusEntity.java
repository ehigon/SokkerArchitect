package com.estivy.sokkerarchitect.storage.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.estivy.sokkerarchitect.core.domain.TrainingType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor(onConstructor_=@__({@Ignore}))
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(tableName = "player_statuses",
        foreignKeys = {
                @ForeignKey(entity = PlayerEntity.class,
                        parentColumns = "id",
                        childColumns = "playerId")
        })
public class PlayerStatusEntity {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(index = true)
    private Long playerId;
    private Integer skillForm;
    private Integer skillExperience;
    private Integer skillTeamwork;
    private Integer skillDiscipline;
    private Integer transferList;
    private Integer skillStamina;
    private Integer skillPace;
    private Integer skillTechnique;
    private Integer skillPassing;
    private Integer skillKeeper;
    private Integer skillDefending;
    private Integer skillPlaymaking;
    private Integer skillScoring;
    private TrainingType trainingType;
    private Integer officialMinutes;
    private Integer unofficialMinutes;
    private Integer trainerSkill;
    private Long week;
    private Integer age;
    private Boolean injured;
}
