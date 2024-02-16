package com.example.repairservice.repository;

import com.example.repairservice.entity.RepairPart
import org.springframework.data.jpa.repository.JpaRepository

interface RepairPartRepository : JpaRepository<RepairPart, Long> {
}