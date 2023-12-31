package com.durys.jakub.acceptationservice.acceptation.domain

import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.neo4j.repository.query.Query
import java.time.LocalDate

interface AcceptationRepository: Neo4jRepository<Employee, String> {

    @Query("MATCH (e:Employee) <-[supervised:SUPERVISED_BY]-(supervisor:Employee)" +
            " where e.id = \$employeeId and supervised.level = \$level and (\$at >= supervised.from and \$at <= coalesce(supervised.to, \$at))" +
            " return supervisor")
    fun acceptants(employeeId: String, level: Int, at: LocalDate): List<Employee>

    @Query("MATCH (e:Employee) <-[supervised:SUPERVISED_BY]-(supervisor:Employee)" +
            " where e.id = \$employeeId and supervised.level = \$level" +
            " return supervisor, supervised")
    fun supervisorConfig(employeeId: String, level: Int): List<Employee>
}