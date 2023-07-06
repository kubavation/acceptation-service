package com.durys.jakub.acceptationservice.employee.domain

import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node("Employee")
class Employee(@Id val id: String) {

    @Relationship(type = "SUPERVISED_BY", direction = Relationship.Direction.INCOMING)
    var supervisors: Set<Employee> = emptySet()

    @Relationship(type = "SUBORDINATES", direction = Relationship.Direction.OUTGOING)
    var subordinates: Set<Employee> = emptySet()

}