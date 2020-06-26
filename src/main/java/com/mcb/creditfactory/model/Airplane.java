package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AIRPLANE")
public class Airplane extends Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;

    @Column(name = "year_of_issue")
    private Short year;
    @Column(name = "fuel_capacity")
    private Integer fuelCapacity;
    private Integer seats;

    @OneToMany(mappedBy = "theAirplaneId", cascade = CascadeType.ALL)
    List<Evaluation> evaluations;
}