package com.compose.mlbdkohinoors.core.extensions

abstract class EntityMapper<Dto, DomainModel> {

    abstract fun mapFromDto(dto: Dto): DomainModel

    abstract fun mapToDto(domainModel: DomainModel): Dto

    open fun mapFromDtoList(dtoList: List<Dto>): List<DomainModel> =
        dtoList.map { mapFromDto(it) }

    fun mapToDtoList(domainList: List<DomainModel>): List<Dto> =
        domainList.map { mapToDto(it) }

}
