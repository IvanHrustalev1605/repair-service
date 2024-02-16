package com.example.repairservice.mappers

import com.example.repairservice.dto.RepairPartDto
import com.example.repairservice.entity.RepairPart
import org.mapstruct.*

@Mapper
interface RepairPartMapper {
     fun toEntity(repairPartDto: RepairPartDto): RepairPart
     fun toDto(repairPart: RepairPart): RepairPartDto

}