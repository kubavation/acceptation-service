package com.durys.jakub.acceptationservice.employee.domain

import org.springframework.data.neo4j.repository.Neo4jRepository

interface EmployeeRepository: Neo4jRepository<Employee, String> {
}