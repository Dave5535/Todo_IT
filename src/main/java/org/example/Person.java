package org.example;

public class Person {
    private static int sequencer = 0;
    //fields
    private int id;
    private String firstName;
    private String lastName;
    private String email;


    //constructors
    public Person(Person creator, Person assignee) {
        this.id = ++sequencer;
    }

    public Person(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);

    }


//methods



    public String getSummary() {


        return "id: " + id + ", Name: " + firstName + " " + lastName + ", email: " + email;
    }//personInformation



//assign

    //getters &setters


    public int getId() {
        return id;
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
        this.email = email;
    }
}//class
