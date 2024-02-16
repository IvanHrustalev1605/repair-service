package com.example.repairservice.controllers

import com.example.repairservice.service.abstracts.RepairPartsService
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/repair")
class RepairController(private val repairPartsService: RepairPartsService) {

}