package org.example;

import Model.AppUser;
import SequencersPack.PersonIdSequencer;

import java.util.Objects;

public class Person implements Comparable<Person> {

    //fields
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;

    //constructors


    public Person(int id, String firstName, String lastName, String email, AppUser credentials) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setCredentials(credentials);
    }

    public Person(String firstName, String lastName, String email) {
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
        return Objects.hash(id,firstName,lastName,email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id == person.id && Objects.equals(firstName, person.firstName)&& Objects.equals(lastName, person.lastName)&& Objects.equals(email,person.email);
    }

    @Override
    public int compareTo(Person personInput) {
        if (this.getId() > personInput.getId()){
            return 1;
        } else if(this.getId() < personInput.getId()){
            return -1;
        } else
            return 0;
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
