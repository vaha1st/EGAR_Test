package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public class CarAdapter implements CollateralObject {
    private CarDto car;

    @Override
    public BigDecimal getValue() {
        return car.getEvaluations().get(0).getValue();
    }

    @Override
    public Short getYear() {
        return car.getYear();
    }

    @Override
    public LocalDate getDate() {
        return car.getEvaluations().get(0).getDate();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }
}
