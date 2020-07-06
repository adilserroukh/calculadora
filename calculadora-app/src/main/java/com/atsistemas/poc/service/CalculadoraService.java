package com.atsistemas.poc.service;

import com.atsistemas.poc.model.OperacionAritmeticaDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculadoraService {

    public BigDecimal suma(OperacionAritmeticaDto operacionAritmeticaDto){
        return operacionAritmeticaDto.getParam1().add(operacionAritmeticaDto.getParam2());
    }

    public BigDecimal resta(OperacionAritmeticaDto operacionAritmeticaDto){
        return operacionAritmeticaDto.getParam1().subtract(operacionAritmeticaDto.getParam2());
    }


}
