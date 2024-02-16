package com.example.repairservice.clients

import com.example.repairservice.dto.RepairPartDto
import com.example.repairservice.entity.RepairPart
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestPart

@FeignClient(value = "storage", url = "localhost:8080/api/storage")
interface StorageFeignClient {

    @GetMapping("/parts-not-installed")
    fun getNotInstalledParts() : List<RepairPart>
    @GetMapping("/byId")
    fun getPartsById(@RequestPart("id") id : Long) : RepairPart
    @PostMapping("/save-part")
    fun savePart(@RequestBody(required = true) repairPartDto: RepairPartDto) : Boolean
}