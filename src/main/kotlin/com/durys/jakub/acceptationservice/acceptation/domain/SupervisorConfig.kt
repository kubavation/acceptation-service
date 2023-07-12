package com.durys.jakub.acceptationservice.acceptation.domain

import org.springframework.data.annotation.Id
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.RelationshipProperties
import org.springframework.data.neo4j.core.schema.TargetNode
import java.time.LocalDate

@RelationshipProperties
data class SupervisorConfig(@Id @GeneratedValue var id: Long?,
                            @TargetNode var employee: Employee,
                            val from: LocalDate, val to: LocalDate?, val level: Int) {

    constructor(employee: Employee, from: LocalDate, to: LocalDate?, level: Int): this(null, employee, from, to, level)

}