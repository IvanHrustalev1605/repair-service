package com.example.repairservice.service.impl

import com.example.repairservice.clients.StorageFeignClient
import com.example.repairservice.entity.Car
import com.example.repairservice.entity.RepairPart
import com.example.repairservice.entity.RepairProcess
import com.example.repairservice.service.abstracts.RepairService
import com.example.repairservice.service.abstracts.CarService
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
@Slf4j
class RepairServiceImpl(private val storageFeignClient: StorageFeignClient,
                        private val carService: CarService) : RepairService {
    val log: Logger = LoggerFactory.getLogger(RepairServiceImpl::class.java)
    override fun repairCar(carId: Long, partIds: List<RepairPart>): Boolean {
        log.info("Starting repair car process...")
        val repairProcess = RepairProcess(null, null, null, null, "", null)
        val carToRepair: Car = carService.takeCarToRepair(carId)
        repairProcess.car = carToRepair
        repairProcess.repairPlace = "Какой то бокс № " + kotlin.random.Random.nextInt(1, 10)
        repairProcess.plannedTime = LocalDate.now().plusDays(20)
        return false
    }

}