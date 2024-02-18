package com.example.repairservice.service.abstracts

import com.example.repairservice.dto.RepairPartDto

interface RepairService {
    fun repairCar(carId: Long, partIds: List<RepairPartDto>) : Boolean
}