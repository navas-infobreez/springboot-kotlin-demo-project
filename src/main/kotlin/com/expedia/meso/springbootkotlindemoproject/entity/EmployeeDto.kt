package com.expedia.meso.springbootkotlindemoproject.entity

import jakarta.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field


@Document(collection = "employee")
data class EmployeeDto(
    @Id
    val id: String?,
    @Field("employee_age")
    var employeeAge : String,
    @Field("employee_name")
    var employeeName : String,
    @Field("employee_id")
    var employeeId : String
)
