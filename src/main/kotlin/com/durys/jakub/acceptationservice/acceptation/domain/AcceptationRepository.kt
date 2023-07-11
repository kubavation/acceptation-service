package com.durys.jakub.acceptationservice.acceptation.domain

import org.springframework.data.neo4j.repository.Neo4jRepository

interface AcceptationRepository: Neo4jRepository<Employee, String> {
}