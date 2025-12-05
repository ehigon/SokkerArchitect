package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;

@Xml
public class TrainersDto {

    @Element
    private List<TrainerDto> trainers;

    public TrainersDto() {
    }

    public TrainersDto(List<TrainerDto> trainers) {
        this.trainers = trainers;
    }

    public List<TrainerDto> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<TrainerDto> trainers) {
        this.trainers = trainers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<TrainerDto> trainers;

        public Builder trainers(List<TrainerDto> trainers) {
            this.trainers = trainers;
            return this;
        }

        public TrainersDto build() {
            return new TrainersDto(trainers);
        }
    }
}
