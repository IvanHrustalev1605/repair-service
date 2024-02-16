package com.example.repairservice.service.abstracts

import com.example.repairservice.entity.RepairPart

interface RepairPartsService {
    fun saveNotInstalledParts()
    fun getAllNotInstalledPartsFromStorage() : List<RepairPart>
    fun getAllRepairPartsByIds(ids: List<Long>) : MutableSet<RepairPart>
    fun setInstalledStatusToParts(partList: List<RepairPart>) : Boolean

}