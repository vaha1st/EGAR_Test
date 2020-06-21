package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

    public List<Evaluation> findByTheCarIdOrderByDate(Car carId);
}
