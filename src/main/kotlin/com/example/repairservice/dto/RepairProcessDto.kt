package com.example.repairservice.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
@JsonIgnoreProperties(ignoreUnknown = true)
open class RepairProcessDto() {
    @JsonProperty(value = "id", required = true)
    open var id: Long? = null
    @JsonProperty(value = "plannedTime", required = true)
    open var plannedTime: LocalDate? = null
    @JsonProperty(value = "spentTime", required = true)
    open var spentTime: LocalDate? = null
    @JsonProperty(value = "overTime", required = true)
    open var overTime: LocalDate? = null
    @JsonProperty(value = "repairPlace", required = true)
    open var repairPlace: String? = null
    @JsonProperty(value = "carId", required = true)
    open var carId: Long? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RepairProcessDto

        if (id != other.id) return false
        if (plannedTime != other.plannedTime) return false
        if (spentTime != other.spentTime) return false
        if (overTime != other.overTime) return false
        if (repairPlace != other.repairPlace) return false
        if (carId != other.carId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (plannedTime?.hashCode() ?: 0)
        result = 31 * result + (spentTime?.hashCode() ?: 0)
        result = 31 * result + (overTime?.hashCode() ?: 0)
        result = 31 * result + (repairPlace?.hashCode() ?: 0)
        result = 31 * result + (carId?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "RepairProcess(id=$id, plannedTime=$plannedTime, spentTime=$spentTime, overTime=$overTime, repairPlace=$repairPlace, carId=$carId)"
    }

}