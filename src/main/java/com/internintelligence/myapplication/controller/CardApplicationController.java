package com.internintelligence.myapplication.controller;

import com.internintelligence.myapplication.dto.CardApplicationRequestDTO;
import com.internintelligence.myapplication.dto.CardApplicationResponseDTO;
import com.internintelligence.myapplication.service.CardApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/card-applications")
public class CardApplicationController {

    private final CardApplicationService cardApplicationService;

    public CardApplicationController(CardApplicationService cardApplicationService) {
        this.cardApplicationService = cardApplicationService;
    }

    @PostMapping
    public ResponseEntity<CardApplicationResponseDTO> createApplication(
            @Valid @RequestBody CardApplicationRequestDTO requestDTO) {
        CardApplicationResponseDTO response = cardApplicationService.createApplication(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CardApplicationResponseDTO>> getAllApplications() {
        List<CardApplicationResponseDTO> responseList = cardApplicationService.getAllApplications();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
}