package com.biblio.alpha.entity;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Validated
@Entity
@Table(name = "customers")
public class CustomerEntity {

    public CustomerEntity() {
    }

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;


    @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL)
    private List<OrderEntity>orderEntityList;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    public List<OrderEntity> getOrderEntityList() {
        return orderEntityList;
    }

    @PrePersist
    public void prePersist() {
        if(age == null) {
            age = 14L;
        }
    }

    @Min(value = 14, message = "The value must be >= 14")
    @NotNull(message = "The value must be not null")
    @Column(name = "age", columnDefinition = "")
    private Long age;

    @NotNull(message = "The value must be not null")
    @Size(min = 6, max = 30, message = "The value must be in the range of 6 to 30")
    @Column(name = "login")
    private String login;

    @NotNull(message = "The value must be not null")
    @Size(min = 10, max = 30, message = "The value must be in the range of 10 to 30")
    @Column(name = "password")
    private String password;

    @Email(regexp = "*@*.*", message = "Email must contain the @ symbol")
    @Column(name = "email")
    private String email;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long bookId) {
        this.customerId = bookId;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setOrderEntityList(List<OrderEntity> orderEntityList) {
        this.orderEntityList = orderEntityList;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
