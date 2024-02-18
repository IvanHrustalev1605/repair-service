package com.example.repairservice.service.abstracts

import com.example.repairservice.dto.RepairPartDto

interface RepairPartsService {
    fun saveNotInstalledParts()
    fun getAllNotInstalledPartsFromStorage() : List<RepairPartDto>
    fun getAllRepairPartsByIds(ids: List<Long>) : MutableSet<RepairPartDto>
    fun setInstalledStatusToParts(partList: List<RepairPartDto>) : Boolean

}