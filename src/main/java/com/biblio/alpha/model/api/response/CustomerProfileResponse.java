package com.biblio.alpha.model.api.response;

import com.biblio.alpha.entity.CustomerEntity;

public class CustomerProfileResponse {
    private String firstName;
    private String lastName;
    private String middleName;
    private Long age;
    private String login;
    private String email;

    public CustomerProfileResponse(String firstName, String lastName, String middleName, Long age, String login, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.login = login;
        this.email = email;
    }

    public CustomerProfileResponse(CustomerEntity customerEntity) {
        this.firstName = customerEntity.getFirstName();
        this.lastName = customerEntity.getLastName();
        this.middleName = customerEntity.getMiddleName();
        this.age = customerEntity.getAge();
        this.login = customerEntity.getLogin();
        this.email = customerEntity.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
