package com.example.repairservice.controllers

import com.example.repairservice.service.abstracts.CarService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cars")
class CarController(private val carService: CarService) {
    @GetMapping
    fun generateNewCars() {
        carService.createCars()
    }
}