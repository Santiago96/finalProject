package com.globant.bootcamp.client.domain;



import java.util.Date;


public class Person {

    private String numDocument;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String mail;
    private String nationality;
    private Date dateBorn;

    public Person() {
    }

    public Person(String numDocument, String name, String lastName, String phoneNumber, String mail, String nationality, Date dateBorn) {
        this.numDocument = numDocument;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.nationality = nationality;
        this.dateBorn = dateBorn;
    }

    public String getNumDocument() {
        return numDocument;
    }

    public void setNumDocument(String numDocument) {
        this.numDocument = numDocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(Date dateBorn) {
        this.dateBorn = dateBorn;
    }
}
