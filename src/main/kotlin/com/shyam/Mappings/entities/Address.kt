package com.shyam.Mappings.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    val addressId : Int?,

    @Column(name = "street")
    val street : String,

    @Column(name = "city")
    val city : String,

    @Column(name = "country")
    val country : String
) {
    constructor(street: String, city: String, country: String) : this(
        addressId = null,
        street = street,
        city = city,
        country = country
    )

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "student_id")
    var student: Student? = null
        private set

    fun assignStudent(student: Student) {
        this.student = student
    }
}
