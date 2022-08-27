package com.example.mapstruct.test

import com.example.mapstruct.domain.Person
import com.example.mapstruct.dto.JobDTO
import com.example.mapstruct.dto.PersonDTO
import com.example.mapstruct.mapper.PersonMapper
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
class Test {

    @Autowired
    private lateinit var personMapper: PersonMapper

    @Test
    fun test() {

        // given
        val person = Person(
            id = 1L,
            name =  "name",
            age =  20,
            phoneNumber = "01012341234",
            birth = LocalDate.of(2003,1,1)
        )

        // when
        val personDTO = personMapper.toDto(person)

        // then
        assertThat(person.id).isEqualTo(personDTO.id)
        assertThat(person.name).isEqualTo(personDTO.name)
        assertThat(person.age).isEqualTo(personDTO.age)
        assertThat(person.phoneNumber).isEqualTo(personDTO.phoneNumber)
        assertThat(person.birth).isEqualTo(personDTO.birth)
    }

    @Test
    fun test2() {

        // given
        val person = Person(
            job = "{\"type\":\"developer\",\"location\":\"Seoul\",\"year\":1}"
        )
        val jobDto = JobDTO(type = "developer", location = "Seoul", year = 1)

        // when
        val personDTO = personMapper.toDto(person)

        // then
        assertThat(personDTO.job).isEqualTo(jobDto)
    }

    @Test
    fun test3() {

        // given
        val personDto = PersonDTO(
            job = JobDTO(type = "developer", location = "Seoul", year = 1)
        )
        val jobJson = "{\"type\":\"developer\",\"location\":\"Seoul\",\"year\":1}"

        // when
        val person = personMapper.toEntity(personDto)

        // then
        assertThat(person.job).isEqualTo(jobJson)
    }
}