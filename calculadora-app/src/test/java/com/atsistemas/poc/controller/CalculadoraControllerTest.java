package com.atsistemas.poc.controller;


import com.atsistemas.poc.model.OperacionAritmeticaDto;
import com.atsistemas.poc.model.TipoOperacionDto;
import com.atsistemas.poc.service.CalculadoraService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class CalculadoraControllerTest {

    private CalculadoraController calculadoraController;
    private CalculadoraService calculadoraService;

    @BeforeEach
    void setUp() {
        calculadoraService = mock(CalculadoraService.class);
        calculadoraController = new CalculadoraController(calculadoraService);
    }

    @Test
    void suma() {

        // Given
        OperacionAritmeticaDto operacionAritmeticaDto = new OperacionAritmeticaDto();
        operacionAritmeticaDto.setOperacion(TipoOperacionDto.SUMA);
        operacionAritmeticaDto.setParam1(BigDecimal.ONE);
        operacionAritmeticaDto.setParam2(BigDecimal.TEN);
        BigDecimal resultadoOperacionExpected = new BigDecimal(11);

        //When
        when(calculadoraService.suma(operacionAritmeticaDto)).thenReturn(resultadoOperacionExpected);

        // Test
        ResponseEntity actual = calculadoraController.calcular(operacionAritmeticaDto);

        // Asserts
        verify(calculadoraService).suma(operacionAritmeticaDto);
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        assertEquals(resultadoOperacionExpected, actual.getBody());



    }

    @Test
    void resta() {

        // Given
        OperacionAritmeticaDto operacionAritmeticaDto = new OperacionAritmeticaDto();
        operacionAritmeticaDto.setOperacion(TipoOperacionDto.RESTA);
        operacionAritmeticaDto.setParam1(BigDecimal.ONE);
        operacionAritmeticaDto.setParam2(BigDecimal.TEN);

        BigDecimal resultadoOperacionExpected = new BigDecimal(-9);

        //When
        when(calculadoraService.resta(operacionAritmeticaDto)).thenReturn(resultadoOperacionExpected);

        // Test
        ResponseEntity actual = calculadoraController.calcular(operacionAritmeticaDto);

        // Asserts
        verify(calculadoraService).resta(operacionAritmeticaDto);
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        assertEquals(resultadoOperacionExpected, actual.getBody());


    }

}