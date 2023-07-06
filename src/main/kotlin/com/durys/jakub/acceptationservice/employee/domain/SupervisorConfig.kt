package com.durys.jakub.acceptationservice.employee.domain

import org.springframework.data.neo4j.core.schema.RelationshipProperties
import org.springframework.data.neo4j.core.schema.TargetNode
import java.time.LocalDate

@RelationshipProperties
data class SupervisorConfig(@TargetNode var employee: Employee, val from: LocalDate, val to: LocalDate?, val level: Int) {

}