package com.example.repairservice.clients

import com.example.repairservice.dto.CarDto
import com.example.repairservice.dto.RepairPartDto
import feign.Headers
import jakarta.mail.Header
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart

@FeignClient(value = "storage", url = "localhost:8080/api/storage")
interface StorageFeignClient {

    @GetMapping("/parts-not-installed")
    fun getNotInstalledParts() : List<RepairPartDto>
    @GetMapping("/byId")
    fun getPartsById(@RequestParam("id") id : Long) : RepairPartDto
    @PostMapping("/save-part")
    fun savePart(@RequestBody(required = true) repairPartDto: RepairPartDto) : Boolean

    @GetMapping("/cars/car-by-id", headers = ["multipart/form-data"])
    fun getCarById(@RequestParam("id") id: Long) : CarDto
    @GetMapping("/car-by-vin")
    fun getCarByVin(@RequestParam("vin") vin: String) : CarDto
    @PostMapping("/saveCar")
    fun saveCar(@RequestBody carDto: CarDto) : Boolean
}