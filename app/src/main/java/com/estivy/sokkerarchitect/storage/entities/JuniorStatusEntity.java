package com.estivy.sokkerarchitect.storage.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.estivy.sokkerarchitect.core.domain.JuniorFormation;

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
}
