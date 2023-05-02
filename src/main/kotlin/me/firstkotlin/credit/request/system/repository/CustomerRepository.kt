package me.firstkotlin.credit.request.system.repository

import me.firstkotlin.credit.request.system.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer,Long>{
}