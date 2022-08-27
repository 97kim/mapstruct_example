package com.example.mapstruct.mapper

import com.example.mapstruct.domain.Car
import com.example.mapstruct.dto.CarDTO
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Component
@Mapper(componentModel = "spring")
interface CarMapper: EntityMapper<CarDTO, Car>