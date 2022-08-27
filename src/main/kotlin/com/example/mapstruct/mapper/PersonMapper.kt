package com.example.mapstruct.mapper

import com.example.mapstruct.domain.Person
import com.example.mapstruct.dto.JobDTO
import com.example.mapstruct.dto.PersonDTO
import com.fasterxml.jackson.databind.ObjectMapper
import org.mapstruct.*
import org.springframework.stereotype.Component

@Component
@Mapper(componentModel = "spring")
interface PersonMapper: EntityMapper<PersonDTO, Person> {

    @Mapping(source = "job", target = "job", qualifiedByName = ["jobDtoToJson"])
    override fun toEntity(dto: PersonDTO): Person

    @Mapping(source = "job", target = "job", qualifiedByName = ["jsonToJobDto"])
    override fun toDto(entity: Person): PersonDTO

    @Mapping(source = "job", target = "job", qualifiedByName = ["jobDtoToJson"])
    override fun toEntity(dtoList: MutableList<PersonDTO>): MutableList<Person>

    @Mapping(source = "job", target = "job", qualifiedByName = ["jsonToJobDto"])
    override fun toDto(entityList: MutableList<Person>): MutableList<PersonDTO>

    companion object {
        @Named("jsonToJobDto")
        @JvmStatic
        fun jsonToJobDto(json: String?): JobDTO {
            return json?.let { ObjectMapper().readValue(it, JobDTO::class.java) } ?: JobDTO()
        }

        @Named("jobDtoToJson")
        @JvmStatic
        fun jobDtoToJson(jobDTO: JobDTO?): String {
            return jobDTO?.let { ObjectMapper().writeValueAsString(it) } ?: ""
        }
    }
}