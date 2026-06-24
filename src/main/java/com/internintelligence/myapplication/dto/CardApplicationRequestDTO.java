package com.internintelligence.myapplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CardApplicationRequestDTO {

    @NotBlank(message = "Kartın növü boş buraxıla bilməz!")
    private String cardType;

    @NotBlank(message = "Valyuta növü seçilməlidir!")
    private String currency;

    @NotBlank(message = "FIN kod məcburidir!")
    @Size(min = 7, max = 7, message = "FIN kod dəqiq 7 simvoldan ibarət olmalıdır!")
    private String finCode;


    public CardApplicationRequestDTO() {
    }

    public CardApplicationRequestDTO(String cardType, String currency, String finCode) {
        this.cardType = cardType;
        this.currency = currency;
        this.finCode = finCode;
    }

    // Getters and Setters
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

    public String getFinCode() {
        return finCode;
    }

    public void setFinCode(String finCode) {
        this.finCode = finCode;
    }
}