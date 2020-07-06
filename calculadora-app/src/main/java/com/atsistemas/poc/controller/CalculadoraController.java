package com.atsistemas.poc.controller;

import com.atsistemas.poc.api.CalcularApi;
import com.atsistemas.poc.model.OperacionAritmeticaDto;
import com.atsistemas.poc.model.TipoOperacionDto;
import com.atsistemas.poc.service.CalculadoraService;
import io.corp.calculator.TracerImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;


@RestController
public class CalculadoraController implements CalcularApi {

    private final CalculadoraService calculadoraService;
    private final TracerImpl tracer= new TracerImpl();

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @Override
    public ResponseEntity<BigDecimal> calcular(@Valid OperacionAritmeticaDto operacionAritmeticaDto) {

        BigDecimal resultadoOperacion = null;

        if (TipoOperacionDto.SUMA == operacionAritmeticaDto.getOperacion()) {
            resultadoOperacion = calculadoraService.suma(operacionAritmeticaDto);
        } else if (TipoOperacionDto.RESTA == operacionAritmeticaDto.getOperacion()) {
            resultadoOperacion = calculadoraService.resta(operacionAritmeticaDto);
        }

        tracer.trace(resultadoOperacion);
        return ResponseEntity.ok(resultadoOperacion);
    }
}