package com.example.mapstruct.domain

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Person(

    @Id
    @Column(name = "person_id")
    var id: Long? = null,

    @Column(name = "name")
    var name: String? = null,

    @Column(name = "age")
    var age: Int? = null,

    @Column(name = "phone_number")
    var phoneNumber: String? = null,

    @Column(name = "birth")
    var birth: LocalDate? = null,

    @Column(name = "job")
    var job: String? = null
)