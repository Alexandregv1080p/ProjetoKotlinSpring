package me.firstkotlin.credit.request.system.controller

import me.firstkotlin.credit.request.system.dto.CustomerDto
import me.firstkotlin.credit.request.system.dto.CustomerUpdateDto
import me.firstkotlin.credit.request.system.dto.CustomerView
import me.firstkotlin.credit.request.system.entity.Customer
import me.firstkotlin.credit.request.system.service.impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customer")
class CustomerResource(
    private val customerService: CustomerService
) {
    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto):ResponseEntity<String>{
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer ${savedCustomer.email} saved")
    }
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }
    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long){
        this.customerService.delete(id)
    }
    @PatchMapping
    fun updateCostumer(
        @RequestParam(value="customerId") id: Long,
        @RequestBody customerUpdateDtoa: CustomerUpdateDto
    ): ResponseEntity<CustomerView>{
        val customer: Customer = this.customerService.findById(id)
        val customerUpdate: Customer = customerUpdateDtoa.toEntity(customer)
        val customerUpdated: Customer = this.customerService.save(customerUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
    }
}