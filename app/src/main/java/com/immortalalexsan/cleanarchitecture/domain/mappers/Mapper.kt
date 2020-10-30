package com.immortalalexsan.cleanarchitecture.domain.mappers

interface Mapper<I, O> {

    fun mapToOutput(input: I): O

    fun mapToInput(output: O): I
}
