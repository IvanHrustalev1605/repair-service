package com.example.repairservice.service.impl

import com.example.repairservice.clients.StorageFeignClient
import com.example.repairservice.dto.RepairPartDto
import com.example.repairservice.service.abstracts.RepairPartsService
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
@Slf4j
class RepairPartsServiceImpl(private val storageFeignClient: StorageFeignClient
) : RepairPartsService {
    val log: Logger = LoggerFactory.getLogger(RepairPartsServiceImpl::class.java)
    override fun saveNotInstalledParts() {

    }

    override fun getAllRepairPartsByIds(ids: List<Long>): MutableSet<RepairPartDto> {
        return mutableSetOf()
    }

    override fun setInstalledStatusToParts(partList: List<RepairPartDto>): Boolean {
        partList.forEach {
            p -> p.installed = true;
//            repairPartRepository.save(p)
            log.info("Отправка ифнормации на склад что запчасть установлена. Номер запчасти " + p.code)
            storageFeignClient.savePart(p)
        }
        return true
    }

    override fun getAllNotInstalledPartsFromStorage(): List<RepairPartDto> {
        return storageFeignClient.getNotInstalledParts()
    }
}