package com.example.repairservice.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class CarDto(
    @JsonProperty(required = false, value = "id")
    open var id: Long,
    @JsonProperty(required = false, value = "vinNumber")
    open var vinNumber: String,
    @JsonProperty(required = false, value = "number")
    open var number: String,
    @JsonProperty(required = false, value = "repairParts")
    open var repairParts: List<RepairPartDto>) : Serializable{

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CarDto

        if (id != other.id) return false
        if (vinNumber != other.vinNumber) return false
        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + vinNumber.hashCode()
        result = 31 * result + number.hashCode()
        return result
    }

    override fun toString(): String {
        return "CarDto(id=$id, vinNumber='$vinNumber', number='$number', repairParts=$repairParts)"
    }

}