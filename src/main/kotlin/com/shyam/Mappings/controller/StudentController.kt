package com.shyam.Mappings.controller

import org.springframework.web.bind.annotation.*
import com.shyam.Mappings.entities.Laptop
import com.shyam.Mappings.entities.Student
import com.shyam.Mappings.entities.Address
import com.shyam.Mappings.services.RestService

@RestController
@RequestMapping("/students")
class StudentController(val restService : RestService) {

    @PostMapping("/addStudentAddress")
    fun addStudentAndAddress(){
        val newStudent = Student("sam","full stack")

        val newAddress1 = Address("TVT","chennai","India")
        val newAddress2 = Address("TVT", "Bangalore", "India")

        var currAddressList : MutableList<Address> = mutableListOf()
        currAddressList.add(newAddress1)
        currAddressList.add(newAddress2)

        newStudent.assignAddress(newAddress1, newAddress2)
        restService.addStudent(newStudent)
    }

    @PostMapping("/addStudent")
    fun addStudent(){
        val newStudent = Student("Jack","Front-end Developer")
        restService.addStudent(newStudent)
    }

    @PostMapping("/addStudentLaptop")
    fun addLaptop(){
        val newStudent = Student("sangeeth"," Nigga")
        val newLaptop = Laptop("V876", "MSI")
        newLaptop.assignStudent(newStudent)
        newStudent.assignLaptop(newLaptop)
        restService.addBoth(newStudent)
    }

    @GetMapping("/findAll")
    fun findAll() : Any {
        return restService.findAll()
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id : Int) : Any {
        return restService.deleteStudentById(id)
    }
}
