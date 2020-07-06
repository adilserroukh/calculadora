package com.atsistemas.poc.service;

import com.atsistemas.poc.model.OperacionAritmeticaDto;
import com.atsistemas.poc.model.TipoOperacionDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculadoraServiceTest {

    private CalculadoraService calculadoraService;


    @BeforeEach
    public void setUp() {
        calculadoraService = new CalculadoraService();

    }

    @Test
    public void suma() {
        // Given
        OperacionAritmeticaDto operacionAritmeticaDto = new OperacionAritmeticaDto();
        operacionAritmeticaDto.setOperacion(TipoOperacionDto.SUMA);
        operacionAritmeticaDto.setParam1(BigDecimal.ONE);
        operacionAritmeticaDto.setParam2(BigDecimal.TEN);
        //When

        // Test
        BigDecimal actual = calculadoraService.suma(operacionAritmeticaDto);

        // Asserts
        assertEquals(new BigDecimal(11), actual);

    }

    @Test
    public void resta() {
        // Given
        OperacionAritmeticaDto operacionAritmeticaDto = new OperacionAritmeticaDto();
        operacionAritmeticaDto.setOperacion(TipoOperacionDto.SUMA);
        operacionAritmeticaDto.setParam1(BigDecimal.ONE);
        operacionAritmeticaDto.setParam2(BigDecimal.TEN);

        // Test
        BigDecimal actual = calculadoraService.resta(operacionAritmeticaDto);

        // Asserts
        assertEquals(new BigDecimal(-9), actual);

    }

}