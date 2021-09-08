package com.alexia.rest.rest_example.model;

import java.util.Objects;

public class Client {

    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;

    public int getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String name) {
        this.first_name = name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Client By Edward {" +
                "id=" + id +
                ", first name='" + first_name + '\'' +
                ", last name' " + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}' + super.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(first_name, client.first_name) &&
                Objects.equals(last_name, client.last_name) &&
                Objects.equals(email, client.email) &&
                Objects.equals(phone, client.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, email, phone);
    }
}
