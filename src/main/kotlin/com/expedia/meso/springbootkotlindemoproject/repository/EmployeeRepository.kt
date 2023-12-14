package com.expedia.meso.springbootkotlindemoproject.repository;

import com.expedia.meso.springbootkotlindemoproject.entity.EmployeeDto
import org.springframework.data.jpa.repository.Query
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : MongoRepository<EmployeeDto, Long> {

    fun findByEmployeeId (employeeId: String): EmployeeDto?
}