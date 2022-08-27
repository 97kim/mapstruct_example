package com.example.mapstruct.mapper

import com.example.mapstruct.dto.JobDTO
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper

/**
 * @param D is Dto type
 * @param E is Entity type
 */
interface EntityMapper<D, E> {

    fun toEntity(dto: D): E

    fun toDto(entity: E): D

    fun toEntity(dtoList: MutableList<D>): MutableList<E>

    fun toDto(entityList: MutableList<E>): MutableList<D>
}