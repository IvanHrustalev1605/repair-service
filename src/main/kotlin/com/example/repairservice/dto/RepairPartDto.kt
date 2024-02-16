package com.example.repairservice.dto

import com.example.repairservice.entity.enums.RepairPartGroup
import java.io.Serializable
import java.time.LocalDateTime

/**
 * DTO for {@link com.example.repairservice.entity.RepairPart}
 */
data class RepairPartDto(
    val id: Long? = null,
    val code: String? = null,
    val resource: Int? = null,
    val installationTime: LocalDateTime? = null,
    val installed: Boolean = false,
    val repairPartGroup: RepairPartGroup? = null
) : Serializable