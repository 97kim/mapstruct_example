package com.example.mapstruct.dto

import java.time.LocalDate

data class PersonDTO(
    var id: Long? = null,

    var name: String? = null,

    var age: Int? = null,

    var phoneNumber: String? = null,

    var birth: LocalDate? = null,

    var job: JobDTO? = null
)