package com.example.repairservice.controllers

import com.example.repairservice.dto.CarDto
import com.example.repairservice.service.abstracts.CarService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cars")
class CarController(private val carService: CarService) {
    @GetMapping
    fun generateNewCars() {
//        carService.createCars()
    }
    @GetMapping("/byId")
    fun getCar(@RequestParam("id") id: Long) : ResponseEntity<CarDto> {
        return ResponseEntity(carService.getCarById(id), HttpStatus.OK)
    }
    @GetMapping("/setCarToDriver")
    fun setCarToDriver(@RequestParam("carId") carId: Long,
                       @RequestParam("driverId") driverId: Long) : ResponseEntity<Boolean> {
        return ResponseEntity(carService.setCarToDriver(carId, driverId), HttpStatus.OK)
    }
}