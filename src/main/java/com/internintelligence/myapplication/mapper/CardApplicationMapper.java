package com.internintelligence.myapplication.mapper;

import com.internintelligence.myapplication.dto.CardApplicationRequestDTO;
import com.internintelligence.myapplication.dto.CardApplicationResponseDTO;
import com.internintelligence.myapplication.entity.CardApplication;
import org.springframework.stereotype.Component;

@Component
public class CardApplicationMapper {


    public CardApplication toEntity(CardApplicationRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }
        CardApplication application = new CardApplication();
        application.setCardType(requestDTO.getCardType());
        application.setCurrency(requestDTO.getCurrency());


        return application;
    }


    public CardApplicationResponseDTO toResponseDTO(CardApplication cardApplication) {
        if (cardApplication == null) {
            return null;
        }
        CardApplicationResponseDTO responseDTO = new CardApplicationResponseDTO();
        responseDTO.setId(cardApplication.getId());
        responseDTO.setCardType(cardApplication.getCardType());
        responseDTO.setCurrency(cardApplication.getCurrency());
        responseDTO.setStatus(cardApplication.getStatus());
        return responseDTO;
    }
}
