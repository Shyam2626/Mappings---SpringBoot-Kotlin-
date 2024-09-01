package com.shyam.Mappings.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "student")
class Student(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentid")
    val studentId : Int?,

    @Column(name = "studentname")
    val studentName : String,

    @Column(name = "about")
    val about : String
) {

    constructor(studentName: String, about: String) : this(
        studentId = null,
        studentName = studentName,
        about = about
    )

    @OneToOne(mappedBy = "student", cascade = [CascadeType.ALL])
    @JsonManagedReference
    var laptop : Laptop? = null

    @OneToMany(mappedBy = "student", cascade = [CascadeType.ALL])
    @JsonManagedReference
    var address : MutableList<Address> = mutableListOf()

    fun assignLaptop(laptop: Laptop) {
        this.laptop = laptop
    }

    fun assignAddress(vararg addresses: Address) {
        for (address in addresses) {
            address.assignStudent(this)
            this.address.add(address)
        }
    }
}
