package com.estivy.sokkerarchitect.storage.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor(onConstructor_ = @__({@Ignore}))
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(tableName = "team",
        foreignKeys = {
                @ForeignKey(entity = CountryEntity.class,
                        parentColumns = "countryId",
                        childColumns = "countryId")
        })
public class TeamEntity {
    public static final int UNIQUE_ID = 1;
    @PrimaryKey
    @Builder.Default
    private Integer id = UNIQUE_ID;
    private Long teamId;
    private String name;
    @ColumnInfo(index = true)
    private Integer countryId;
    private Integer regionId;
    private String dateCreated;
    private Double rank;
    private Integer national;
    private Integer colShirtKeep;
    private Integer colTrausKeep;
    private Integer colShirt;
    private Integer colTraus;
    private Integer colShirt2;
    private Integer colTraus2;
    private String arenaName;
    private Long money;
    private Integer fanclubCount;
    private Integer fanclubMood;
    private Integer juniorsMax;
    private Integer trainingTypeGk;
    private Integer trainingTypeDef;
    private Integer trainingTypeMid;
    private Integer trainingTypeAtt;
}
