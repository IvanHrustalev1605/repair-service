package com.example.repairservice.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
open class RepairProcess(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null,
    @Column
    open var plannedTime: LocalDate?,
    @Column
    open var spentTime: LocalDate?,
    @Column
    open var overTime: LocalDate?,
    @Column
    open var repairPlace: String,

    @OneToOne
    @JoinColumn
    open var car: Car?
)