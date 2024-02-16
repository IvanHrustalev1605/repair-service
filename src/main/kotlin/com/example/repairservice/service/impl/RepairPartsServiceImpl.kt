package com.example.repairservice.service.impl

import com.example.repairservice.clients.StorageFeignClient
import com.example.repairservice.entity.RepairPart
import com.example.repairservice.mappers.RepairPartMapper
import com.example.repairservice.repository.RepairPartRepository
import com.example.repairservice.service.abstracts.RepairPartsService
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
@Slf4j
class RepairPartsServiceImpl(private val repairPartRepository: RepairPartRepository,
                             private val storageFeignClient: StorageFeignClient,
                             private val repairPartMapper: RepairPartMapper
) : RepairPartsService {
    val log: Logger = LoggerFactory.getLogger(RepairPartsServiceImpl::class.java)
    override fun saveNotInstalledParts() {
        repairPartRepository.saveAll(getAllNotInstalledPartsFromStorage())
    }

    override fun getAllRepairPartsByIds(ids: List<Long>): MutableSet<RepairPart> {
        return repairPartRepository.findAllById(ids).toMutableSet()
    }

    override fun setInstalledStatusToParts(partList: List<RepairPart>): Boolean {
        partList.forEach {
            p -> p.installed = true;
            repairPartRepository.save(p)
            log.info("Отправка ифнормации на склад что запчасть установлена. Номер запчасти " + p.code)
            storageFeignClient.savePart(repairPartMapper.toDto(p))
        }
        return true
    }

    override fun getAllNotInstalledPartsFromStorage(): List<RepairPart> {
        return storageFeignClient.getNotInstalledParts()
    }
}