package com.example.repairservice.service.abstracts

import com.example.repairservice.dto.DriverDto

interface DriverService {
    fun getDriverById(id: Long) : DriverDto

}
