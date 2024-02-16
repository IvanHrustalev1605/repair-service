package com.example.repairservice.entity

import com.example.repairservice.entity.enums.RepairPartGroup
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "repairParts")
@JsonIgnoreProperties(ignoreUnknown = true)
open class RepairPart(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null,

    @Column(name = "code", unique = true)
    open var code: String,

    @Column(name = "resource")
    open var resource: Int,

    @Column(name = "installationTime")
    open var installationTime: LocalDateTime,

    @Column
    open var installed: Boolean = false,

    @ManyToOne
    open var car: Car?,

    @Enumerated
    open var repairPartGroup: RepairPartGroup?
)
