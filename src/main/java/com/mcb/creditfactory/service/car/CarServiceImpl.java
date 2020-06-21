package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.model.Evaluation;
import com.mcb.creditfactory.repository.CarRepository;
import com.mcb.creditfactory.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private ExternalApproveService approveService;

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private EvaluationRepository evaluationRepository;

    @Override
    public boolean approve(CarDto dto) {
        return approveService.approve(new CarAdapter(dto)) == 0;
    }

    @Override
    public Car save(Car car) {
        for (Evaluation eva: car.getEvaluations()
             ) {
            eva.setTheCarId(car);
        }
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> load(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car fromDto(CarDto dto) {
        return new Car(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getPower(),
                dto.getYear(),
                dto.getEvaluations()
        );
    }

    @Override
    public CarDto toDTO(Car car) {
        System.out.println(evaluationRepository.findByTheCarIdOrderByDate(car).isEmpty());
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getPower(),
                car.getYear(),
                car.getEvaluations()
        );
    }

    @Override
    public Long getId(Car car) {
        return car.getId();
    }
}
