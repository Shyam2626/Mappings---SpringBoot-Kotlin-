package com.shyam.Mappings.services

import com.shyam.Mappings.entities.Student
import com.shyam.Mappings.repositories.StudentRepository
import org.springframework.stereotype.Service

@Service
class RestService(private val studentRepository: StudentRepository){

    fun addStudent(newStudent : Student){
        studentRepository.save(newStudent)
    }

    fun addBoth(newStudent: Student) {
        studentRepository.save(newStudent)
    }

    fun findAll(): Any {
        return studentRepository.findAll()
    }

    fun deleteStudentById(id: Int): Any {
        studentRepository.deleteById(id)
        return studentRepository.findAll()
    }

}