package me.firstkotlin.credit.request.system.service.impl

import me.firstkotlin.credit.request.system.entity.Customer
import me.firstkotlin.credit.request.system.repository.CustomerRepository
import me.firstkotlin.credit.request.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,

): ICustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)


    override fun findById(customerId: Long): Customer =
        this.customerRepository.findById(customerId).orElseThrow{
            throw RuntimeException("Id ${customerId} not found")
        }
    override fun delete(customerId: Long) = this.customerRepository.deleteById(customerId)
}