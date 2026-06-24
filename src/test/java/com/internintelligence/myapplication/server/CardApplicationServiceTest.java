package com.internintelligence.myapplication.server;

import com.internintelligence.myapplication.dto.CardApplicationRequestDTO;
import com.internintelligence.myapplication.dto.CardApplicationResponseDTO;
import com.internintelligence.myapplication.entity.CardApplication;
import com.internintelligence.myapplication.mapper.CardApplicationMapper;
import com.internintelligence.myapplication.repository.CardApplicationRepository;
import com.internintelligence.myapplication.service.CardApplicationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CardApplicationServiceTest {
    @Mock
    private CardApplicationRepository repository;

    @Mock
    private CardApplicationMapper mapper;

    @InjectMocks
    private CardApplicationServiceImpl service;

    private CardApplicationRequestDTO requestDTO;
    private CardApplication cardApplication;
    private CardApplicationResponseDTO responseDTO;

    @BeforeEach
    void setUp() {
        requestDTO = new CardApplicationRequestDTO();
        requestDTO.setFinCode("7ABCD67");
        requestDTO.setCardType("VISA_GOLD");
        requestDTO.setCurrency("AZN");

        cardApplication = new CardApplication(
                1L,
                1L,
                "VISA_GOLD",
                "AZN",
                "PENDING",
                LocalDateTime.now()
        );

        responseDTO = new CardApplicationResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setId(1l);
        responseDTO.setCardType("VISA_GOLD");
        responseDTO.setCurrency("AZN");
        responseDTO.setStatus("PENDING");
    }

    @Test
    void testCreateCardApplication_Success() {
        when(mapper.toEntity(any(CardApplicationRequestDTO.class))).thenReturn(cardApplication);
        when(repository.save(any(CardApplication.class))).thenReturn(cardApplication);
        when(mapper.toResponseDTO(any(CardApplication.class))).thenReturn(responseDTO);
        CardApplicationResponseDTO result = service.createApplication(requestDTO);
        assertNotNull(result);
        assertEquals("PENDING", result.getStatus());
        assertEquals(1L, result.getId());
        assertEquals("AZN", result.getCurrency());

        verify(repository, times(1)).save(any(CardApplication.class));
    }
}
