package com.example.repairservice.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

@JsonIgnoreProperties(ignoreUnknown = true)
class DriverDto() {
    @JsonProperty(value = "id", required = true)
    open var id: Long? = null
    @JsonProperty(value = "name", required = false)
    open var name: String? = null
    @JsonProperty(value = "age", required = false)
    open var age: Int? = null
    @JsonProperty(value = "licenseNumber", required = false)
    open var licenseNumber: String? = null
    @JsonProperty(value = "licenseExpiryDate", required = false)
    open var licenseExpiryDate: LocalDate? = null
    @JsonProperty(value = "vehicleType", required = false)
    open var vehicleType: String? = null
    @JsonProperty(value = "rating", required = false)
    open var rating: Double? = null
    @JsonProperty(value = "position", required = false)
    open var position: Long? = null
    @JsonProperty(value = "cars", required = false)
    open var cars: MutableList<CarDto>? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DriverDto

        if (id != other.id) return false
        if (name != other.name) return false
        if (age != other.age) return false
        if (licenseNumber != other.licenseNumber) return false
        if (licenseExpiryDate != other.licenseExpiryDate) return false
        if (vehicleType != other.vehicleType) return false
        if (rating != other.rating) return false
        if (position != other.position) return false
        if (cars != other.cars) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (age ?: 0)
        result = 31 * result + (licenseNumber?.hashCode() ?: 0)
        result = 31 * result + (licenseExpiryDate?.hashCode() ?: 0)
        result = 31 * result + (vehicleType?.hashCode() ?: 0)
        result = 31 * result + (rating?.hashCode() ?: 0)
        result = 31 * result + (position?.hashCode() ?: 0)
        result = 31 * result + (cars?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "DriverDto(id=$id, name=$name, age=$age, licenseNumber=$licenseNumber, licenseExpiryDate=$licenseExpiryDate, vehicleType=$vehicleType, rating=$rating, position=$position, cars=$cars)"
    }


}