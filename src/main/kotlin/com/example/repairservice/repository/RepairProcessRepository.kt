package com.example.repairservice.repository;

import com.example.repairservice.entity.RepairProcess
import org.springframework.data.jpa.repository.JpaRepository

interface RepairProcessRepository : JpaRepository<RepairProcess, Long> {
}