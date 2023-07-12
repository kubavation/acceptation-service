package com.durys.jakub.acceptationservice.acceptation.infrastructure.`in`

import com.durys.jakub.acceptationservice.acceptation.domain.AcceptationRepository
import com.durys.jakub.acceptationservice.acceptation.domain.Employee
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/acceptation")
class AcceptationController(val acceptationRepository: AcceptationRepository) {

    @GetMapping("/employees/{employeeId}")
    fun acceptants(@PathVariable employeeId: String,
                   @RequestParam at: LocalDate, @RequestParam level: Int): List<Employee> = acceptationRepository.acceptants(employeeId, level, at)
}