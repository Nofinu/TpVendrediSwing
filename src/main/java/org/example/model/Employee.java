package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String bloodGroup;
    private String contactNo;
    private String qualification;
    private Date doj;
    private String address;
    private String employeeImage;

    public Employee(String name, String gender, int age, String bloodGroup, String contactNo, String qualification, Date doj, String address, String employeeImage) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.contactNo = contactNo;
        this.qualification = qualification;
        this.doj = doj;
        this.address = address;
        this.employeeImage = employeeImage;
    }
}
