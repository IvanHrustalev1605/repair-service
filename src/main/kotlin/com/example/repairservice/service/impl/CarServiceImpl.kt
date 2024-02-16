package com.example.repairservice.service.impl

import com.example.repairservice.entity.Car
import com.example.repairservice.entity.RepairPart
import com.example.repairservice.entity.enums.CarBrand
import com.example.repairservice.repository.CarRepository
import com.example.repairservice.service.abstracts.CarService
import com.example.repairservice.service.abstracts.RepairPartsService
import jakarta.transaction.Transactional
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
@Slf4j
class CarServiceImpl(private val carRepository: CarRepository,
                     private val repairPartsService: RepairPartsService) : CarService {
    val log: Logger = LoggerFactory.getLogger(CarServiceImpl::class.java)
    override fun takeCarToRepair(carId: Long): Car {
        return carRepository.findById(carId).get()
    }
    @Transactional
    override fun installPartsToCar(car: Car, partIds: List<Long>): Boolean {
        val repairParts: MutableSet<RepairPart> = repairPartsService.getAllRepairPartsByIds(partIds)
        car.repairParts = repairParts
        carRepository.save(car)
        repairPartsService.setInstalledStatusToParts(repairParts.toList())
        return false
    }

    override fun createCars() {
        for (i in 1 .. 200) {
            val car = Car(null, "", "", 0, null, null)
            car.carBrand = generateCarBrand()
            car.mileage = Random.nextInt(100000, 1000000)
            car.model = generateRandomString(6)
            car.number = generateRandomString(12)
            carRepository.save(car)
        }
    }
    private fun generateCarBrand() : CarBrand {
        return CarBrand.entries[Random.nextInt(0, CarBrand.entries.size)]
    }
    private fun generateRandomString(length: Int): String {
        val chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray()
        return (1..length)
            .map { Random.nextInt(0, chars.size) }
            .map(chars::get)
            .joinToString("")
    }
}