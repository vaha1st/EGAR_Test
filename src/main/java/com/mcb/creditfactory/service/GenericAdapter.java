package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public class GenericAdapter<T extends Collateral> implements CollateralObject {
    private T dto;

    @Override
    public BigDecimal getValue() {
        // Из отсортированного по дате списка оценок берется первый элемент, т.е самый свежий
        return dto.getEvaluations().get(0).getValue();
    }

    @Override
    public Short getYear() {
        return dto.getYear();
    }

    @Override
    public LocalDate getDate() {
        return dto.getEvaluations().get(0).getDate();
    }

    @Override
    public CollateralType getType() {
        if (dto.getClass()==CarDto.class) {
            return CollateralType.CAR;
        } else if (dto.getClass()==AirplaneDto.class) {
            return CollateralType.AIRPLANE;
        } else throw new IllegalArgumentException("Переданная сущность "+ dto.getClass()+" не подходит по известным" +
                "определениям типов. Пожалуйста проверьте com.mcb.creditfactory.service.GenericAdapter.getType()");
    }
}
