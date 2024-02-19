package com.example.repairservice.controllers

import com.example.repairservice.dto.DriverDto
import com.example.repairservice.service.abstracts.DriverService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/drivers")
class DriverController(private val driverService: DriverService) {

    @GetMapping()
    fun getDriver(@RequestParam("id") id : Long) : ResponseEntity<DriverDto> {
        return ResponseEntity(driverService.getDriverById(id), HttpStatus.OK)
    }
}