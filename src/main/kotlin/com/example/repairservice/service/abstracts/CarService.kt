package com.example.repairservice.service.abstracts

import com.example.repairservice.entity.Car

interface CarService {
    fun takeCarToRepair(carId: Long) : Car
    fun installPartsToCar(car: Car, partIds: List<Long>) : Boolean
    fun createCars()

}