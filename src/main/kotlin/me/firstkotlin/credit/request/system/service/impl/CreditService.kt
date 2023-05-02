package me.firstkotlin.credit.request.system.service.impl

import me.firstkotlin.credit.request.system.entity.Credit
import me.firstkotlin.credit.request.system.repository.CreditRepository
import me.firstkotlin.credit.request.system.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
):ICreditService {
    override fun save(credit: Credit): Credit{
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }


    override fun findAllCustomer(customerId: Long): List<Credit> {
        TODO("Not yet implemented")
    }

    override fun findByCreditCode(creditCode: UUID): Credit {
        TODO("Not yet implemented")
    }
}