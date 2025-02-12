package com.estivy.sokkerarchitect.storage.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.estivy.sokkerarchitect.core.domain.National;

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
@Entity(tableName = "players",
        foreignKeys = {
                @ForeignKey(entity = CountryEntity.class,
                        parentColumns = "countryId",
                        childColumns = "countryId")
        })
public class PlayerEntity {
    @PrimaryKey
    private Long id;
    private String name;
    private String surname;
    @ColumnInfo(index = true)
    private Integer countryId;
    private Integer age;
    private Integer height;
    private Double weight;
    private Double bmi;
    private Long teamId;
    private Long youthTeamId;
    private Long value;
    private Long wage;
    private Integer cards;
    private Integer goals;
    private Integer assists;
    private Integer matches;
    private Integer ntCards;
    private Integer ntGoals;
    private Integer ntAssists;
    private Integer ntMatches;
    private Integer injuryDays;
    private National national;
    private boolean active;
    private String notes;
}
