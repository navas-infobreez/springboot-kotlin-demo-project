package com.expedia.meso.springbootkotlindemoproject.controller

import com.expedia.meso.springbootkotlindemoproject.entity.EmployeeDto
import com.expedia.meso.springbootkotlindemoproject.repository.EmployeeRepository
import com.expedia.meso.springbootkotlindemoproject.request.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/employee")
class EmployeeController(@Autowired val employeeRepo: EmployeeRepository) {


    @GetMapping
    fun getAllEmployees() = employeeRepo.findAll()

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable("id") id: String): ResponseEntity<EmployeeDto> {
        val employee = employeeRepo.findByEmployeeId(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(employee)
    }

    @PostMapping
    fun createNewEmployee(@RequestBody employee: Employee): EmployeeDto {
        val newEmployee = EmployeeDto(
            id = null,
            employeeAge = employee.employeeAge,
            employeeName = employee.employeeName,
            employeeId = employee.employeeId
        )
        return employeeRepo.save(newEmployee)
    }

    @DeleteMapping("/{id}")
    fun deleteEmloyeeById(@PathVariable("id") id: String): ResponseEntity<String> {
        val employee = employeeRepo.findByEmployeeId(id) ?: throw  throw ResponseStatusException(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "no employee found"
        )
        employeeRepo.delete(employee)
        return ResponseEntity.accepted().build()
    }

}