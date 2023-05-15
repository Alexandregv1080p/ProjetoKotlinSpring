package me.firstkotlin.credit.request.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.firstkotlin.credit.request.system.entity.Address
import me.firstkotlin.credit.request.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "Invalid input")val firstName: String,
    @field:NotEmpty(message = "Invalid input")val lastName: String,
    @field:CPF(message = "Invalid CPF")val cpf: String,
    @field:NotNull(message = "Invalid null") val income: BigDecimal,
    @field:Email(message = "Invalid email")val email: String,
    @field:NotEmpty(message = "Invalid input")val password: String,
    @field:NotEmpty(message = "Invalid input")val zipCode: String,
    @field:NotEmpty(message = "Invalid input")val street: String
){
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
