create table CAR (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  power DOUBLE,
  year_of_issue YEAR

);

create table AIRPLANE (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  manufacturer VARCHAR2(500),
  year_of_issue YEAR,
  fuel_capacity INT,
  seats INT
);

create table EVALUATION (
    id IDENTITY primary key,
    assessment_date date,
    assessed_value DEC(20),
    car_id bigint,
    airplane_id bigint,
    foreign key (car_id) references CAR (id)
)