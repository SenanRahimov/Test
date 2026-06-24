package com.internintelligence.myapplication.service;

import com.internintelligence.myapplication.dto.CardApplicationRequestDTO;
import com.internintelligence.myapplication.dto.CardApplicationResponseDTO;

import java.util.List;

public interface CardApplicationService {

     CardApplicationResponseDTO createApplication(CardApplicationRequestDTO requestDTO);
     List<CardApplicationResponseDTO> getAllApplications();
}
