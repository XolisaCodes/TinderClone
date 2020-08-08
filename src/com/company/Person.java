package com.company;

public class Person {
    private String bio;
    private String name;
    private String gender;
    private String location;

    private int age;


    public Person(String name, String gender, String bio, String location, int age) {
        this.age = age;
        this.bio = bio;
        this.name = name;
        this.gender = gender;
        this.location = location;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getBio() {
        return this.bio;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    public String getLocation() {
        return this.location;
    }

    public String toString() {
        return "I am " + this.name;
    }
}
