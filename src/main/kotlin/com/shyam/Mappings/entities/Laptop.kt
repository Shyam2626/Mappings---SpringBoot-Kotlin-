package com.shyam.Mappings.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "laptop")
class Laptop(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "laptopid")
    val laptopId : Int?,

    @Column(name = "modelnumber")
    val modelNumber : String,

    @Column(name = "brand")
    val brand : String

) {

    constructor(modelNumber: String, brand: String) : this(
        laptopId = null,
        modelNumber = modelNumber,
        brand = brand
    )

    @OneToOne
    @JoinColumn(name = "studentid")
    @JsonBackReference
    var student : Student? = null

    fun assignStudent(student: Student){
        this.student = student
    }
}