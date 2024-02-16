package com.example.repairservice.entity

import com.example.repairservice.entity.enums.CarBrand
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity(name = "cars")
@JsonIgnoreProperties(ignoreUnknown = true)
open class Car(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null,

    @Column(name = "model", updatable = false)
    open var model: String?,

    @Column(name = "number", unique = true, updatable = false)
    open  var number: String?,

    //пробег
    @Column
    open var mileage: Int?,

    @Enumerated(value = EnumType.STRING)
    open var carBrand: CarBrand?,

    @OneToMany(mappedBy = "car")
    open var repairParts: MutableSet<RepairPart>?
)
