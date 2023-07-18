package com.durys.jakub.acceptationservice.acceptation.domain

import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node("Employee")
data class Employee(@Id val id: String) {

    @Relationship(type = "SUPERVISED_BY", direction = Relationship.Direction.INCOMING)
    var supervisors: Set<SupervisorConfig> = emptySet()


     fun withSupervisors(supervisorConfig: Set<SupervisorConfig>): Employee {
        this.supervisors = supervisorConfig
        return this
    }


}