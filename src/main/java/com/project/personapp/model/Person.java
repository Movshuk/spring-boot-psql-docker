package com.project.personapp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@ApiModel(
        value       = "Person Entity",
        description = "Table person"
)
@Entity
@Table(name = "person", schema = "office")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(
            value = "Identity",
            name = "id",
            dataType = "Long",
            example = "null",
            hidden = true)
    private Long id;

    @Column(name = "born_date")
    @ApiModelProperty(
            value = "was born",
            name = "born",
            dataType = "String",
            example = "2019-01-01")
    private LocalDate born;

    @Column(name = "first_name")
    @ApiModelProperty(
            value = "First Name",
            name = "firstName",
            dataType = "String",
            example = "Alexander")
    private String firstName;

    @Column(name = "last_name")
    @ApiModelProperty(
            value = "Last Name",
            name = "lastName",
            dataType = "String",
            example = "Pushkin")
    private String lastName;

    public Person() {
    }

    public Person(Long id, LocalDate born, String firstName, String lastName) {
        this.id = id;
        this.born = born;
        this.firstName = firstName;
        this.lastName = lastName;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
