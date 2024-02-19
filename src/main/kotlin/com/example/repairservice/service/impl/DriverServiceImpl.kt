package com.example.repairservice.service.impl

import com.example.repairservice.clients.StorageFeignClient
import com.example.repairservice.dto.DriverDto
import com.example.repairservice.service.abstracts.DriverService
import org.springframework.stereotype.Service

@Service
class DriverServiceImpl(private val feignClient: StorageFeignClient) : DriverService {
    override fun getDriverById(id: Long): DriverDto {
        return feignClient.getDriverById(id)
    }
}