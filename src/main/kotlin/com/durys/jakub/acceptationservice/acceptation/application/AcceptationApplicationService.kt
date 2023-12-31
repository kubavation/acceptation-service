package com.durys.jakub.acceptationservice.acceptation.application

import com.durys.jakub.acceptationservice.acceptation.domain.AcceptationRepository
import com.durys.jakub.acceptationservice.acceptation.domain.Employee
import com.durys.jakub.acceptationservice.acceptation.domain.SupervisorConfig
import com.durys.jakub.acceptationservice.acceptation.infrastructure.model.AcceptationConfigDTO
import org.springframework.stereotype.Service

@Service
class AcceptationApplicationService(val repository: AcceptationRepository) {

    fun changeSupervisors(employeeId: String, config: Set<AcceptationConfigDTO>) {

        val employee = employee(employeeId)
                .withSupervisors(
                        config.map { SupervisorConfig(employee(it.employeeId), it.from, it.to, it.level) }.toSet())

        repository.save(employee)
    }

    fun acceptationConfig(employeeId: String, level: Int): List<Employee> {
        return repository.supervisorConfig(employeeId, level);
    }

    private fun employee(employeeId: String): Employee {
        return repository.findById(employeeId)
                .orElse(Employee(employeeId))
    }

}