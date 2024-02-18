package com.example.repairservice.service.impl

import com.example.repairservice.clients.StorageFeignClient
import com.example.repairservice.dto.CarDto
import com.example.repairservice.dto.RepairPartDto
import com.example.repairservice.dto.RepairProcessDto
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
    override fun repairCar(carId: Long, partIds: List<RepairPartDto>): Boolean {
        log.info("Starting repair car process...")
        val repairProcessDto = RepairProcessDto()
        val carToRepair: CarDto = carService.takeCarToRepair(carId)
        repairProcessDto.carId = carToRepair.id
        repairProcessDto.repairPlace = "Какой то бокс № " + kotlin.random.Random.nextInt(1, 10)
        repairProcessDto.plannedTime = LocalDate.now().plusDays(20)
        return false
    }

}