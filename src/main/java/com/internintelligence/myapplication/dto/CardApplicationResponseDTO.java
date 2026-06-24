package com.internintelligence.myapplication.dto;

public class CardApplicationResponseDTO {

    private Long id;
    private String cardType;
    private String currency;
    private String status;


    public CardApplicationResponseDTO() {
    }

    public CardApplicationResponseDTO(Long id, String cardType, String currency, String status) {
        this.id = id;
        this.cardType = cardType;
        this.currency = currency;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
