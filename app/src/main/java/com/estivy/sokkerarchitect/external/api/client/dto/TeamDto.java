package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "team")
public class TeamDto {
    @PropertyElement(name = "teamID")
    private Long teamId;
    @PropertyElement
    private String name;
    @PropertyElement(name = "countryID")
    private Integer countryId;
    @PropertyElement(name = "regionID")
    private Integer regionId;
    @PropertyElement
    private String dateCreated;
    @PropertyElement
    private Double rank;
    @PropertyElement
    private Integer national;
    @PropertyElement
    private Integer colShirtKeep;
    @PropertyElement
    private Integer colTrausKeep;
    @PropertyElement
    private Integer colShirt;
    @PropertyElement
    private Integer colTraus;
    @PropertyElement
    private Integer colShirt2;
    @PropertyElement
    private Integer colTraus2;
    @PropertyElement
    private String arenaName;
    @PropertyElement
    private Long money;
    @PropertyElement
    private Integer trainingType;
    @PropertyElement
    private Integer trainingFormation;
    @PropertyElement
    private Integer fanclubCount;
    @PropertyElement
    private Integer fanclubMood;
    @PropertyElement
    private Integer juniorsMax;
    @PropertyElement
    private Integer trainingTypeGk;
    @PropertyElement
    private Integer trainingTypeDef;
    @PropertyElement
    private Integer trainingTypeMid;
    @PropertyElement
    private Integer trainingTypeAtt;

    public TeamDto() {
    }

    public TeamDto(Long teamId, String name, Integer countryId, Integer regionId, String dateCreated, Double rank,
                   Integer national, Integer colShirtKeep, Integer colTrausKeep, Integer colShirt, Integer colTraus,
                   Integer colShirt2, Integer colTraus2, String arenaName, Long money, Integer trainingType,
                   Integer trainingFormation, Integer fanclubCount, Integer fanclubMood, Integer juniorsMax,
                   Integer trainingTypeGk, Integer trainingTypeDef, Integer trainingTypeMid, Integer trainingTypeAtt) {
        this.teamId = teamId;
        this.name = name;
        this.countryId = countryId;
        this.regionId = regionId;
        this.dateCreated = dateCreated;
        this.rank = rank;
        this.national = national;
        this.colShirtKeep = colShirtKeep;
        this.colTrausKeep = colTrausKeep;
        this.colShirt = colShirt;
        this.colTraus = colTraus;
        this.colShirt2 = colShirt2;
        this.colTraus2 = colTraus2;
        this.arenaName = arenaName;
        this.money = money;
        this.trainingType = trainingType;
        this.trainingFormation = trainingFormation;
        this.fanclubCount = fanclubCount;
        this.fanclubMood = fanclubMood;
        this.juniorsMax = juniorsMax;
        this.trainingTypeGk = trainingTypeGk;
        this.trainingTypeDef = trainingTypeDef;
        this.trainingTypeMid = trainingTypeMid;
        this.trainingTypeAtt = trainingTypeAtt;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }

    public Integer getNational() {
        return national;
    }

    public void setNational(Integer national) {
        this.national = national;
    }

    public Integer getColShirtKeep() {
        return colShirtKeep;
    }

    public void setColShirtKeep(Integer colShirtKeep) {
        this.colShirtKeep = colShirtKeep;
    }

    public Integer getColTrausKeep() {
        return colTrausKeep;
    }

    public void setColTrausKeep(Integer colTrausKeep) {
        this.colTrausKeep = colTrausKeep;
    }

    public Integer getColShirt() {
        return colShirt;
    }

    public void setColShirt(Integer colShirt) {
        this.colShirt = colShirt;
    }

    public Integer getColTraus() {
        return colTraus;
    }

    public void setColTraus(Integer colTraus) {
        this.colTraus = colTraus;
    }

    public Integer getColShirt2() {
        return colShirt2;
    }

    public void setColShirt2(Integer colShirt2) {
        this.colShirt2 = colShirt2;
    }

    public Integer getColTraus2() {
        return colTraus2;
    }

    public void setColTraus2(Integer colTraus2) {
        this.colTraus2 = colTraus2;
    }

    public String getArenaName() {
        return arenaName;
    }

    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Integer getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(Integer trainingType) {
        this.trainingType = trainingType;
    }

    public Integer getTrainingFormation() {
        return trainingFormation;
    }

    public void setTrainingFormation(Integer trainingFormation) {
        this.trainingFormation = trainingFormation;
    }

    public Integer getFanclubCount() {
        return fanclubCount;
    }

    public void setFanclubCount(Integer fanclubCount) {
        this.fanclubCount = fanclubCount;
    }

    public Integer getFanclubMood() {
        return fanclubMood;
    }

    public void setFanclubMood(Integer fanclubMood) {
        this.fanclubMood = fanclubMood;
    }

    public Integer getJuniorsMax() {
        return juniorsMax;
    }

    public void setJuniorsMax(Integer juniorsMax) {
        this.juniorsMax = juniorsMax;
    }

    public Integer getTrainingTypeGk() {
        return trainingTypeGk;
    }

    public void setTrainingTypeGk(Integer trainingTypeGk) {
        this.trainingTypeGk = trainingTypeGk;
    }

    public Integer getTrainingTypeDef() {
        return trainingTypeDef;
    }

    public void setTrainingTypeDef(Integer trainingTypeDef) {
        this.trainingTypeDef = trainingTypeDef;
    }

    public Integer getTrainingTypeMid() {
        return trainingTypeMid;
    }

    public void setTrainingTypeMid(Integer trainingTypeMid) {
        this.trainingTypeMid = trainingTypeMid;
    }

    public Integer getTrainingTypeAtt() {
        return trainingTypeAtt;
    }

    public void setTrainingTypeAtt(Integer trainingTypeAtt) {
        this.trainingTypeAtt = trainingTypeAtt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long teamId;
        private String name;
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
        private Integer trainingType;
        private Integer trainingFormation;
        private Integer fanclubCount;
        private Integer fanclubMood;
        private Integer juniorsMax;
        private Integer trainingTypeGk;
        private Integer trainingTypeDef;
        private Integer trainingTypeMid;
        private Integer trainingTypeAtt;

        public Builder teamId(Long teamId) { this.teamId = teamId; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder countryId(Integer countryId) { this.countryId = countryId; return this; }
        public Builder regionId(Integer regionId) { this.regionId = regionId; return this; }
        public Builder dateCreated(String dateCreated) { this.dateCreated = dateCreated; return this; }
        public Builder rank(Double rank) { this.rank = rank; return this; }
        public Builder national(Integer national) { this.national = national; return this; }
        public Builder colShirtKeep(Integer colShirtKeep) { this.colShirtKeep = colShirtKeep; return this; }
        public Builder colTrausKeep(Integer colTrausKeep) { this.colTrausKeep = colTrausKeep; return this; }
        public Builder colShirt(Integer colShirt) { this.colShirt = colShirt; return this; }
        public Builder colTraus(Integer colTraus) { this.colTraus = colTraus; return this; }
        public Builder colShirt2(Integer colShirt2) { this.colShirt2 = colShirt2; return this; }
        public Builder colTraus2(Integer colTraus2) { this.colTraus2 = colTraus2; return this; }
        public Builder arenaName(String arenaName) { this.arenaName = arenaName; return this; }
        public Builder money(Long money) { this.money = money; return this; }
        public Builder trainingType(Integer trainingType) { this.trainingType = trainingType; return this; }
        public Builder trainingFormation(Integer trainingFormation) { this.trainingFormation = trainingFormation; return this; }
        public Builder fanclubCount(Integer fanclubCount) { this.fanclubCount = fanclubCount; return this; }
        public Builder fanclubMood(Integer fanclubMood) { this.fanclubMood = fanclubMood; return this; }
        public Builder juniorsMax(Integer juniorsMax) { this.juniorsMax = juniorsMax; return this; }
        public Builder trainingTypeGk(Integer trainingTypeGk) { this.trainingTypeGk = trainingTypeGk; return this; }
        public Builder trainingTypeDef(Integer trainingTypeDef) { this.trainingTypeDef = trainingTypeDef; return this; }
        public Builder trainingTypeMid(Integer trainingTypeMid) { this.trainingTypeMid = trainingTypeMid; return this; }
        public Builder trainingTypeAtt(Integer trainingTypeAtt) { this.trainingTypeAtt = trainingTypeAtt; return this; }

        public TeamDto build() {
            return new TeamDto(teamId, name, countryId, regionId, dateCreated, rank, national, colShirtKeep, colTrausKeep,
                    colShirt, colTraus, colShirt2, colTraus2, arenaName, money, trainingType, trainingFormation,
                    fanclubCount, fanclubMood, juniorsMax, trainingTypeGk, trainingTypeDef, trainingTypeMid, trainingTypeAtt);
        }
    }
}
