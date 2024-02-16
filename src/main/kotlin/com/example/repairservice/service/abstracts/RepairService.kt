package com.example.repairservice.service.abstracts

import com.example.repairservice.entity.RepairPart

interface RepairService {
    fun repairCar(carId: Long, partIds: List<RepairPart>) : Boolean
}