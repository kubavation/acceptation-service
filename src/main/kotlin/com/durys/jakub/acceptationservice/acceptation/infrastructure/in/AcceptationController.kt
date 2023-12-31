package com.durys.jakub.acceptationservice.acceptation.infrastructure.`in`

import com.durys.jakub.acceptationservice.acceptation.application.AcceptationApplicationService
import com.durys.jakub.acceptationservice.acceptation.domain.AcceptationRepository
import com.durys.jakub.acceptationservice.acceptation.domain.Employee
import com.durys.jakub.acceptationservice.acceptation.domain.SupervisorConfig
import com.durys.jakub.acceptationservice.acceptation.infrastructure.model.AcceptationConfigDTO
import com.durys.jakub.acceptationservice.api.EmployeeDTO
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/acceptation")
class AcceptationController(val acceptationRepository: AcceptationRepository,
                            val acceptationApplicationService: AcceptationApplicationService) {

    @GetMapping("/employees/{employeeId}")
    fun acceptants(@PathVariable employeeId: String,
                   @RequestParam at: LocalDate, @RequestParam level: Int): List<EmployeeDTO> {
        return acceptationRepository.acceptants(employeeId, level, at)
                .map { EmployeeDTO(it.id) }
    }

    @GetMapping("/employees/{employeeId}/config/{level}")
    fun acceptantsWithConfig(@PathVariable employeeId: String, @PathVariable level: Int): List<Employee> {
        return acceptationApplicationService.acceptationConfig(employeeId, level);
    }

    @PatchMapping("/employees/{employeeId}")
    fun changeAcceptants(@PathVariable employeeId: String, @RequestBody config: Set<AcceptationConfigDTO>) {
        acceptationApplicationService.changeSupervisors(employeeId, config)
    }


}