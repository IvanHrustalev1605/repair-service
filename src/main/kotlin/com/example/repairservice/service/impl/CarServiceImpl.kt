package com.example.repairservice.service.impl

import com.example.repairservice.clients.StorageFeignClient
import com.example.repairservice.dto.CarDto
import com.example.repairservice.exceptions.SomethingGoWrongException
import com.example.repairservice.service.abstracts.CarService
import com.example.repairservice.service.abstracts.RepairPartsService
import jakarta.transaction.Transactional
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
@Slf4j
class CarServiceImpl(private val storageFeignClient: StorageFeignClient,
                     private val repairPartsService: RepairPartsService,
) : CarService {
    val log: Logger = LoggerFactory.getLogger(CarServiceImpl::class.java)
    override fun takeCarToRepair(carId: Long): CarDto {
        return storageFeignClient.getCarById(carId)
    }
    @Transactional
    override fun installPartsToCar(car: CarDto, partIds: List<Long>): Boolean {
        val repairParts = repairPartsService.getAllRepairPartsByIds(partIds)
//        car.repairParts = repairParts
        storageFeignClient.saveCar(car)
        repairPartsService.setInstalledStatusToParts(repairParts.toList())
        return false
    }

    override fun getCarById(id: Long): CarDto {
        return storageFeignClient.getCarById(id)
    }

    override fun setCarToDriver(carId: Long, driverId: Long): Boolean {
        val car = storageFeignClient.getCarById(carId)
        if (car.drivers?.size == 0) {
            car.drivers = mutableListOf(storageFeignClient.getDriverById(driverId))
            storageFeignClient.saveCar(car)
            return true
        } else {
            throw SomethingGoWrongException("На машине с номер " + car.number + " уже есть водитель!")
        }
    }
}