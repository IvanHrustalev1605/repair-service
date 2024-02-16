package com.example.repairservice.repository;

import com.example.repairservice.entity.Car
import org.springframework.data.jpa.repository.JpaRepository

interface CarRepository : JpaRepository<Car, Long> {

}