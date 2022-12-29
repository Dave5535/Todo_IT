package Model;

import java.util.Date;
import java.util.Objects;

public class Person implements Comparable<Person> {

    //fields
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;
    private AppUser appUser;

    private Integer appId;
    private Date regDate;
    //constructors


    public Person(Integer id, String firstName, String lastName, String email, AppUser credentials) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setCredentials(credentials);
    }
    public Person(){

    }

    public Person(String firstName, String lastName, String email,AppUser appUser) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setAppUser(appUser);
    }
    public Person(Integer id,String firstName, String lastName, String email) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }
    public Person(Integer id,String firstName, String lastName, String email,Date regDate,Integer appId) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setRegDate(regDate);
        setAppId(appId);
    }

//methods

    @Override
    public String toString() {
        return "id: " + id + ", Name: " + firstName + " " + lastName + ", email: " + email +
              " regdate: " + regDate + " appid: " + appId  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,firstName,lastName,email,regDate,appId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName)&& Objects.equals(lastName, person.lastName)
                && Objects.equals(email,person.email)&& Objects.equals(regDate,person.regDate)&& Objects.equals(appId,person.appId);
    }

    @Override
    public int compareTo(Person personInput) {
        return this.getId().compareTo(personInput.getId());
    }


//assign

    //getters &setters

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date setRegDate) {
        regDate = setRegDate;
    }
}//class
