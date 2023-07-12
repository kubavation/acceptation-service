package com.durys.jakub.acceptationservice.api

import com.durys.jakub.acceptationservice.acceptation.domain.AcceptationRepository
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/api/acceptation")
class AcceptationsApi(val acceptationRepository: AcceptationRepository) {

    @GetMapping("/employees/{employeeId}")
    fun acceptants(@PathVariable employeeId: String,
                   @RequestParam at: LocalDate, @RequestParam level: Int): List<EmployeeDTO> {
        return acceptationRepository.acceptants(employeeId, level, at)
                .map { EmployeeDTO(it.id) }
    }

}