package com.example.repairservice.dto

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.time.LocalDateTime

/**
 * DTO for {@link com.example.repairservice.entity.RepairPart}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class RepairPartDto(
    @JsonProperty(value = "id", required = false)
    var id: Long? = null,
    @JsonProperty(value = "code", required = false)
    var code: String? = null,
    @JsonProperty(value = "resource", required = false)
    var resource: Int? = null,
    @JsonProperty(value = "installationTime", required = false)
    var installationTime: LocalDateTime? = null,
    @JsonProperty(value = "installed", required = false)
    var installed: Boolean = false,
    @JsonProperty(value = "repairPartGroup", required = false)
    var repairPartGroup: Int? = null
) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RepairPartDto

        if (id != other.id) return false
        if (code != other.code) return false
        if (resource != other.resource) return false
        if (installationTime != other.installationTime) return false
        if (installed != other.installed) return false
        if (repairPartGroup != other.repairPartGroup) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (code?.hashCode() ?: 0)
        result = 31 * result + (resource ?: 0)
        result = 31 * result + (installationTime?.hashCode() ?: 0)
        result = 31 * result + installed.hashCode()
        result = 31 * result + (repairPartGroup ?: 0)
        return result
    }

    override fun toString(): String {
        return "RepairPartDto(id=$id, code=$code, resource=$resource, installationTime=$installationTime, installed=$installed, repairPartGroup=$repairPartGroup)"
    }

}