package com.prueba.model;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class DataModel {

    private Long id;
    private String href;
    private String correlationId;
    private String description;
    private String creationDate;
    private String category;
    private String source;
    private String status;
    private String statusChangeDate;
    private String relatedParty;
    private String relatedObject;
    private String note;
    private List<Channel> channel;
    private List<AdditionalData> additionalData;

}
