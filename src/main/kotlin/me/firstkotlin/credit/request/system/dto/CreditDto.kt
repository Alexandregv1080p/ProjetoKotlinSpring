package me.firstkotlin.credit.request.system.dto

import jakarta.validation.constraints.NotEmpty
import me.firstkotlin.credit.request.system.entity.Credit
import me.firstkotlin.credit.request.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotEmpty(message = "Invalid input")val creditValue: BigDecimal,
    @field:NotEmpty(message = "Invalid input")val dayFirstInstallment: LocalDate,
    @field:NotEmpty(message = "Invalid input")val numberOfInstallments: Int,
    @field:NotEmpty(message = "Invalid input")val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
