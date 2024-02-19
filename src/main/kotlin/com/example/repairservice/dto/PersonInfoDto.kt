package com.example.repairservice.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDateTime
@JsonIgnoreProperties(ignoreUnknown = true)
open class PersonInfoDto {
    open var login: String? = null
    open var firstName: String? = null
    open var middleName: String? = null
    open var secondName: String? = null
    open var email: String? = null
    open var dopInfo: String? = null
    open var age: Int? = null
    open var createdAt: LocalDateTime? = null
    open var updatedAt: LocalDateTime? = null
}