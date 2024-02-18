package com.example.repairservice.repository;

import com.example.repairservice.dto.RepairProcessDto
import org.springframework.data.jpa.repository.JpaRepository

interface RepairProcessRepository : JpaRepository<RepairProcessDto, Long> {
}