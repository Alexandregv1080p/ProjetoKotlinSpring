package me.firstkotlin.credit.request.system.service

import me.firstkotlin.credit.request.system.entity.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit

    fun findAllCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(creditCode: UUID): Credit
}