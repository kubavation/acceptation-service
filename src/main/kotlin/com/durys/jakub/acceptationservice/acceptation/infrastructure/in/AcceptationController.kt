package com.durys.jakub.acceptationservice.acceptation.infrastructure.`in`

import com.durys.jakub.acceptationservice.acceptation.domain.AcceptationRepository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/acceptation")
class AcceptationController(val acceptationRepository: AcceptationRepository) {

    
}