package com.example.repairservice.service.abstracts

import com.example.repairservice.dto.CarDto

interface CarService {
    fun takeCarToRepair(carId: Long) : CarDto
    fun installPartsToCar(car: CarDto, partIds: List<Long>) : Boolean
    fun getCarById(id : Long) :CarDto
    fun setCarToDriver(carId: Long, driverId: Long) : Boolean

}