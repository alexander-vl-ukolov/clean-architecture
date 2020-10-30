package com.immortalalexsan.cleanarchitecture.domain.mappers

class ListMapperImpl<I, O>(private val mapper: Mapper<I, O>) : ListMapper<I, O> {

    override fun mapToOutput(input: List<I>): List<O> {
        return input.map { mapper.mapToOutput(it) }
    }

    override fun mapToInput(output: List<O>): List<I> {
        return output.map { mapper.mapToInput(it) }
    }
}
