package com.example.repairservice.schedullers

import com.example.repairservice.service.abstracts.RepairPartsService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class RepairPartsScheduler(private val repairPartsService: RepairPartsService) {
    //каждый день в 2 часа ночи
    @Scheduled(cron = "0 0 2 * * *")
    fun checkNotInstalledPartsInStorage() {
        repairPartsService.saveNotInstalledParts()
    }
}