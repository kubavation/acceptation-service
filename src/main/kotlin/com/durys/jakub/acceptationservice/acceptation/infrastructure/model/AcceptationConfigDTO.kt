package com.durys.jakub.acceptationservice.acceptation.infrastructure.model

import java.time.LocalDate

data class AcceptationConfigDTO(val employeeId: String, val from: LocalDate, val to: LocalDate?, val level: Int) {
}