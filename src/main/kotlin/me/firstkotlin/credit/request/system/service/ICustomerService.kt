package me.firstkotlin.credit.request.system.service

import me.firstkotlin.credit.request.system.entity.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer

    fun findById(customerId: Long): Customer

    fun delete(customerId: Long)
}