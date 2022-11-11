package org.example;

import Model.AppUser;

public class Person {
    private static int sequencer = 0;
    //fields
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;

    //constructors
    public Person() {
        this.id = (++sequencer);
    }

    public Person(String firstName, String lastName, String email) {
        this();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);

    }


//methods

    @Override
    public String toString() {
        return "id: " + id + ", Name: " + firstName + " " + lastName + ", email: " + email;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


//assign

    //getters &setters

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("firstName param was null");
        this.firstName = firstName;
    }

    //
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("lastName param was null");
        this.lastName = lastName;
    }

    //
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) throw new IllegalArgumentException("Email can't be null.");
        this.email = email;
    }


}//class
