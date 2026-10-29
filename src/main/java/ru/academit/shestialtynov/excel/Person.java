package ru.academit.shestialtynov.excel;

public class Person {
    private int age;
    private String surname;
    private String name;
    private String phoneNumber;

    public Person() {
    }

    public Person(int age, String surname, String name, String phoneNumber) {
        this.age = age;
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
