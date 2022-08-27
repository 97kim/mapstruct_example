package com.example.mapstruct.domain

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Car (

    @Id
    @Column(name = "car_id")
    var id: Long? = null,

    @Column(name = "name")
    var name: String? = null,

    @Column(name = "color")
    var color: String? = null,
)