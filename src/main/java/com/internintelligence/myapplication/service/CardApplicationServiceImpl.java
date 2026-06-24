package com.internintelligence.myapplication.service;

import com.internintelligence.myapplication.dto.CardApplicationRequestDTO;
import com.internintelligence.myapplication.dto.CardApplicationResponseDTO;
import com.internintelligence.myapplication.entity.CardApplication;
import com.internintelligence.myapplication.mapper.CardApplicationMapper;
import com.internintelligence.myapplication.repository.CardApplicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardApplicationServiceImpl implements CardApplicationService {

    private final CardApplicationRepository repository;
    private final CardApplicationMapper mapper;

    public CardApplicationServiceImpl(CardApplicationRepository repository, CardApplicationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public CardApplicationResponseDTO createApplication(CardApplicationRequestDTO requestDTO) {
        CardApplication application = mapper.toEntity(requestDTO);
        application.setStatus("PENDING");
        application.setCreatedAt(LocalDateTime.now());

        CardApplication savedApplication = repository.save(application);
        return mapper.toResponseDTO(savedApplication);
    }

    @Override
    public List<CardApplicationResponseDTO> getAllApplications() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}

